package programmers.lv2;

import java.util.*;
import java.lang.*;

/*
17:32~ 18:20
compareTo, compareToIgnoreCase 차이
*/
public class _3차_파일명_정렬 {
    public String[] solution(String[] files) {
        String[] answer = {};
        ArrayList<File> repository = new ArrayList<>();

        for(String file : files){
            repository.add(new File(file,splitFileName(file)));
            //System.out.println(repository.get(0).head + " "+ repository.get(0).number + " "+repository.get(0).tail);
        }

        repository.sort((File f1, File f2) -> {
            if(f1.head.toUpperCase().equals(f2.head.toUpperCase())){
                return f1.number-f2.number;
            }
            return f1.head.compareToIgnoreCase(f2.head);
        });

        answer = new String[repository.size()];

        for(int i=0;i<answer.length;i++){
            answer[i]=repository.get(i).origin;
        }

        return answer;
    }

    public ArrayList<String> splitFileName(String file){
        ArrayList<String> splited = new ArrayList<>();
        StringBuilder head = new StringBuilder("");
        StringBuilder number = new StringBuilder("");
        StringBuilder tail = new StringBuilder("");
        int fileLen = file.length();

        for(int i=0;i<fileLen;i++){
            char cur = file.charAt(i);
            if( cur>='0' && cur <='9'){
                if(tail.length() != 0){
                    tail.append(cur);
                    continue;
                }
                number.append(cur);
                continue;
            }
            if(number.length() ==0){
                head.append(cur);
                continue;
            }
            tail.append(cur);
        }
        splited.add(head.toString());
        splited.add(number.toString());
        splited.add(tail.toString());

        return splited;
    }

    public class File{
        public String origin;
        public String head;
        public int number;
        public String tail;

        public File(String origin, ArrayList<String> splited){
            this.origin = origin;
            this.head = splited.get(0);
            this.number = Integer.parseInt(splited.get(1));
            this.tail = splited.get(2);
        }
    }
}
