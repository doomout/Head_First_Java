package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient {
    public void go() {
        //서버 주소와 포트 번호
        InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 6050);
        //TWR 구문을 이용하여 코드가 완료되면 SocketChannel 이 자동으로 닫히도록 만든다.
        //open() 메서드를 호출하여 SocketChannel 을 생성한다.
        try (SocketChannel socketChannel = SocketChannel.open(serverAddress)) {

            //SocketChannel 로 부터 읽어들이는 Reader을 생성한다.
            Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);

            //SocketChannel 로 부터 가져온 Reader에 BufferedReader를 연쇄 시킨다.
            BufferedReader reader = new BufferedReader(channelReader);

            //readLine() 는 파일에 연쇄된 BufferedReader을 쓸 때 사용한 readLine()와 완전히 똑같다.
            //BufferedReader의 메서드를 호출할 때 그 객체에서는 문자들이 어디에서 오는지에 대해 전혀 몰라도 된다.
            String advice = reader.readLine();
            System.out.println("오늘 당신이 할 일 : " + advice);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DailyAdviceClient().go();
    }
}
