package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainWinController {
    //элементы с формы
    @FXML public TextArea text1;
    @FXML public TextArea text2;
    @FXML public Label ta;
    @FXML public Button button1;
    @FXML public Button button2;
    @FXML public Button button3;
    @FXML public Button button4;

    protected int sh=0;

    @FXML
    public void handleReset(MouseEvent mouseEvent) {
        //внутренний массив с которым ми работаем
        char[] digits= new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё','ж', 'з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
        char[] digits2= new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё','ж', 'з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

        int k=-100; char ch1;
        String t1=text1.getText(), t2="", t3=""; //переменные

        //делаем сдвиг для массива букв
        if(sh<0) {
            for (int i = 0; i > sh; i--) {
                ch1 = digits2[0];
                for (int j = 0; j < digits2.length; j++) {
                    if (j == digits2.length - 1) {
                        digits2[j] = ch1;
                    } else {
                        digits2[j] = digits2[j + 1];
                    }
                }
            }
        }else {
            for (int i=0;i<sh;i++){
                ch1=digits2[digits2.length-1];
                for (int j=digits2.length-2;j>=0;j--){
                    digits2[j+1]=digits2[j];
                    if (j==0) {
                        digits2[0]=ch1;
                    }
                }
            }
        }

        // сверяем и сопоставляем наши буквы с буквами для шифра, заменяем их на сдвинутые
        for (int i=0;i<t1.length();i++){
            for (int j=0;j<digits2.length;j++){
                if (t1.charAt(i) == digits2[j])  {
                    k=j; break; // кзнаем место в массиве
                } else {
                    k=-100;
                }
            }
            if(k==-100){
                t2+=t1.charAt(i);
            } else {
                t2+=digits[k]; //заменяем на нашу букву
            }
        }
        text2.setText(t2); //выводим на экран
    }

    //добавляем 3 кнопки с разными действиями
    @FXML
    public void shift2(MouseEvent mouseEvent) {
        sh--;
        if(sh<-33){sh=-33;}
        ta.setText("Shift:"+sh);
    }
    @FXML
    public void shift1(MouseEvent mouseEvent) {
        sh++;
        if(sh>33){sh=33;}
        ta.setText("Shift:"+sh);
    }
    @FXML
    public void reset(MouseEvent mouseEvent) {
        sh=0;
        ta.setText("Shift:"+sh);
    }
}
