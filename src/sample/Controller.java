package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    //left side
    @FXML
    Button aktualizuj;
    @FXML
    TextField miesiactext, zarobkitext;
    @FXML
    private TableColumn<MiesięcznyZarobek, String> miesiac;
    @FXML
    private TableColumn<MiesięcznyZarobek, String> zarobki;

    //right side
    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;
    @FXML
    BarChart<String,String> wykres;
    @FXML
    TableView<MiesięcznyZarobek> tabela;





    Boolean isInitialized = false;
    XYChart.Series series1 = new XYChart.Series();
    public void FillIn(){


        series1.getData().add(new XYChart.Data("Styczeń",Double.parseDouble(String.valueOf(5.0))));
        MiesięcznyZarobek m = new MiesięcznyZarobek("Styczeń","5000");
        tabela.getItems().add(m);
        series1.getData().add(new XYChart.Data("Luty",Double.parseDouble(String.valueOf(2.0))));
        MiesięcznyZarobek m1 = new MiesięcznyZarobek("Luty","2000");
        tabela.getItems().add(m1);
        series1.getData().add(new XYChart.Data("Marzec",Double.parseDouble(String.valueOf(1.0))));
        MiesięcznyZarobek m2 = new MiesięcznyZarobek("Marzec","1000");
        tabela.getItems().add(m2);
        series1.getData().add(new XYChart.Data("Kwiecień",Double.parseDouble(String.valueOf(2.0))));
        MiesięcznyZarobek m3 = new MiesięcznyZarobek("Kwiecień","2000");
        tabela.getItems().add(m3);
        series1.getData().add(new XYChart.Data("Maj",Double.parseDouble(String.valueOf(1.0))));
        MiesięcznyZarobek m4 = new MiesięcznyZarobek("Maj","1000");
        tabela.getItems().add(m4);
        series1.getData().add(new XYChart.Data("Czerwiec",Double.parseDouble(String.valueOf(3.0))));
        MiesięcznyZarobek m5 = new MiesięcznyZarobek("Czerwiec","3000");
        tabela.getItems().add(m5);
        series1.getData().add(new XYChart.Data("Lipiec",Double.parseDouble(String.valueOf(2.0))));
        MiesięcznyZarobek m6 = new MiesięcznyZarobek("Lipiec","2000");
        tabela.getItems().add(m6);
        series1.getData().add(new XYChart.Data("Sierpień",Double.parseDouble(String.valueOf(0.0))));
        series1.getData().add(new XYChart.Data("Wrzesień",Double.parseDouble(String.valueOf(0.0))));
        series1.getData().add(new XYChart.Data("Pażdziernik",Double.parseDouble(String.valueOf(0.0))));
        series1.getData().add(new XYChart.Data("Listopad",Double.parseDouble(String.valueOf(0.0))));
        series1.getData().add(new XYChart.Data("Grudzień",Double.parseDouble(String.valueOf(0.0))));



        wykres.getData().add(series1);
}

    public void initialize() {
        miesiac.setCellValueFactory(new PropertyValueFactory<>("miesiac"));
        zarobki.setCellValueFactory(new PropertyValueFactory<>("zarobki"));
        isInitialized = true;
        FillIn();
    }

    public void uzupenij(){
        String mies=miesiactext.getText();
        String zarob=zarobkitext.getText();
        String zarob2;
        Number zarobNumber = -1;
        double Zarobki= Double.valueOf(zarob);
        Zarobki=Zarobki/1000;
        zarob2=Double.toString(Zarobki);


        try{
            zarobNumber = Double.parseDouble(zarob2);
        }catch(NumberFormatException e){
            System.out.println("To nie jest double!");
        }


        if(!isInitialized){
            initialize();
        }

        if(zarobNumber.doubleValue()>=0 && mies.length()>0){

            setGraph(mies,zarobNumber);
            MiesięcznyZarobek m = new MiesięcznyZarobek(mies,zarob);
            tabela.getItems().add(m);

        }

        miesiactext.clear();
        zarobkitext.clear();

    }

    public void setGraph(String mies, Number zarob){

        series1.getData().add(new XYChart.Data(mies,zarob));
        wykres.getData().add(series1);

    }

}
