package sample;
// библиотеки
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // переопределяем метод Start
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(); // создаем загрузчик

        loader.setLocation(getClass().getResource("mainWin.fxml"));
        // указываем локацию формы для сборки дизайна проекта, а так же их объектов

        Parent root = loader.load(); //подгружаем наши данные
        primaryStage.setTitle("Shifrotext");// меняем заголовок проекта
        primaryStage.setScene(new Scene(root, 600, 400)); //задаем размеры
        primaryStage.show(); //делаем его видимым для демонстрации
    }


    public static void main(String[] args) {
        launch(args);
    }
}