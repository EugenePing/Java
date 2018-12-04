package Shapenko;

public class Practice2 {
    private static int coiunter=0;
    public static void main(String[] args) {
    StringBuilder text=new StringBuilder("Водоспад Вікторія невитримує високого тиску води.");
    findCharacterV(text);
        System.out.println(coiunter);
    }
    /*Беру кожну букву і перевіряю чи вона 'в', якщо 'в', то перевіряє чи перед нею був
     * пропуск(визначає чи початок слова); далі перевіряю чи після є пропуск(перевірка на прийменник),
     * якщо ні, то я знайшов слово, яке починається на 'в'*/
    private static void findCharacterV(StringBuilder text){
        for(int i=0;i<text.length();i++){
            if(text.substring(i,i+1).equalsIgnoreCase("в")){
                if(i==text.length()-1){
                    break;
                }
                if(i==0){
                    if(text.charAt(i+1)!=' '){
                        coiunter++;

                    }
                    continue;
                }

                if(text.charAt(i-1)==' '){
                    if(text.charAt(i+1)!=' '){
                        coiunter++;
                    }else {
                        continue;
                    }

                }
            }
        }
    }
}
