package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
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
    CategoryAxis miesiacedane;
    @FXML
    NumberAxis zarobkidane;
    @FXML
    BarChart<String,String> wykres;
    @FXML
    TableView<MiesięcznyZarobek> tabela;

    Boolean isInitialized = false;
    XYChart.Series series1 = new XYChart.Series();

    public void initialize() {
        miesiac.setCellValueFactory(new PropertyValueFactory<>("miesiac"));
        zarobki.setCellValueFactory(new PropertyValueFactory<>("zarobki"));
        isInitialized = true;
    }


    public void uzupenij(){
        String mies=miesiactext.getText();
        String zarob=zarobkitext.getText();
        Number zarobNumber = -10;

        try{
            zarobNumber = Double.parseDouble(zarob);
        }catch(NumberFormatException e){
            System.out.println("To nie jest double!");
        }


        if(!isInitialized){
            initialize();
        }

        System.out.println(mies);
        System.out.println(zarob);
        System.out.println(zarobNumber);
        System.out.println("xd: " + mies.length());

        if(zarobNumber.doubleValue()>=0 && mies.length()>0){
            MiesięcznyZarobek m = new MiesięcznyZarobek(mies,zarob);
            tabela.getItems().add(m);

            setGraph(mies,zarobNumber);
        }

        miesiactext.clear();
        zarobkitext.clear();

    }

    public void setGraph(String mies, Number zarob){


        series1.getData().add(new XYChart.Data(mies,zarob));
        wykres.getData().add(series1);
    }

}
