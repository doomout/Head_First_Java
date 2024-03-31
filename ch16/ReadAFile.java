package ch16;

import java.io.*;

class ReadAFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("MyText.txt");
            //FileReader는 텍스트 파일로 연결되는 문자를 위한 연결 스트림
            FileReader fileReader = new FileReader(myFile);

            //읽기 작업의 효율을 향상시키기 위해 FileReader 를 BufferedReader에 연쇄 시킨다.
            //버퍼가 비워진 후에멘 실제로 파일을 읽어오는 작업을 한다.
            BufferedReader reader = new BufferedReader(fileReader);

            //행을 읽어올 때마다 각 행을 저장하기 위한 변수
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
