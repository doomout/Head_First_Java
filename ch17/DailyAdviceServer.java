package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class DailyAdviceServer {
    //이 배열에 있는 조언이 클라이언트로 전달된다.
    final private String[] adviceList = {
        "조금씩 먹어.",
        "번아웃을 조심해",
        "스트레스 받지마",
        "근력 운동을 해",
        "혼자 다 할려고 하지마"};
    private final Random random = new Random();

    public void go() {
        //이 서버의 포트로 들어오는 클라이언트 요청을 감시한다.
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(6050));  //클라이언트 포트와 동일하게 맞췄다.

            //클라이언트 요청이 올 때 까지 무한 반복으로 대기한다.
            while (serverChannel.isOpen()) {
                SocketChannel clientChannel = serverChannel.accept();

                //클라이언트 채널에 대해 출력 스트림을 생성하고 PrintWriter()로 감싼다.
                //PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
                // PrintWriter를 생성할 때 UTF-8 문자 인코딩을 명시적으로 지정한다.(한글 출력시 에러나서 수정)
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(Channels.newOutputStream(clientChannel), StandardCharsets.UTF_8), true);
                String advice = getAdvice();

                //클라이언트에 String로 된 메세지을 보낸다.
                writer.println(advice); 
                // 연결을 닫는다.
                writer.close();
                //서버 콘솔로 출력하여 어떤 메세지가 갔는지 확인용
                System.out.println(advice);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int nextAdvice = random.nextInt(adviceList.length);
        return adviceList[nextAdvice];
    }

    public static void main(String[] args) {
        new DailyAdviceServer().go();
    }    
}
