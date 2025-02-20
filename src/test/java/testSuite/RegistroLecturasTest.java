package testSuite;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import models.Lectura;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import singletonSession.Session;
import util.ScrollUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RegistroLecturasTest extends TestBase {
    @Test
    public void checkRegisterLecturaNormal(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String userPassword = "1234";
        loginAsUser("admin","4dm1n.123",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.lecturaEditText.setText("13000");
        readingActivity.confirmarButton.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed("LECTURA NORMAL"));
    }
    @Test
    public void checkRegisterLecturaNormalCycle() throws IOException {
        String tplNumber = "19";
        String userName = "user"+tplNumber;
        String userPassword = "1234";
        String value = "0";
        String printerName = "endelp1";

        String adminName = "admin.prueba";
        String adminPassword = "ZXCVB";
        String filePath = "src/test/resources/lecturas_2.csv"; // Ruta del CSV
        List<Lectura> lecturas = leerDatosCSV(filePath);

        loginAsUser(adminName,adminPassword,tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();

        for (Lectura lec : lecturas) {
            readingActivity.buscadorButton.clickControl();
            readingActivity.buscadorTextBox.setTextAndSubmit(lec.getTlxCli());
            Assertions.assertTrue(readingActivity.checkNroConsumidor(lec.getTlxCli()));
            readingActivity.lecturaEditText.setText(lec.getNuevaLectura());
            readingActivity.confirmarButton.clickControl();
            readingActivity.buscadorButton.clickControl();
            readingActivity.buscadorTextBox.setTextAndSubmit(lec.getTlxCli());
            String lecturaRegistrada = readingActivity.lecturaEditText.getTextControl();
            System.out.println("LA LECTURA REGISTRADA ES: "+lecturaRegistrada);
            //Assertions.assertEquals(lec.getNuevaLectura(),lecturaRegistrada);
        }
        /*********
        String nroConsumidor = "103243";
        String lectura = "14866";
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.checkNroConsumidor(nroConsumidor));
        readingActivity.lecturaEditText.setText(lectura);
        readingActivity.confirmarButton.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
         */
    }
    @Test
    public void checkBuscadorLecturas(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "505648";String userPassword = "1234";
        loginAsUser("admin","4dm1n.123",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.checkNroConsumidor(nroConsumidor));
    }
    @Test
    public void checkRegisterLecturaConsumoElevado(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "285979";
        int registroLectura = 99000;
        String userPassword = "1234";
        loginAsUser("admin","4dm1n.123",tplNumber, userName, userPassword, printerName);

        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.lecturaEditText.setText(String.valueOf(registroLectura));
        readingActivity.confirmarButton.clickControl();
        readingActivity.confimarConsumoElevado();
        cameraActivity.tomarFotografia.clickControl();
        cameraActivity.confirmarFotografia.clickControl();
        readingActivity.confimarPostConsumoElevado();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed("CONSUMO ELEVADO"));

    }
    @Test
    public void checkRegisterLecturaCalculoFueraDeRango(){
        String tplNumber = "250";
        String userName = "user250";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "478864";
        int registroLectura = 9;
        String userPassword = "1234";
        loginAsUser("admin","1234",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.lecturaEditText.setText(String.valueOf(registroLectura));
        readingActivity.confirmarButton.clickControl();
        readingActivity.confimarConsumoElevado();
        cameraActivity.tomarFotografia.clickControl();
        cameraActivity.confirmarFotografia.clickControl();
        readingActivity.confimarPostConsumoElevado();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed("CALCULO FUERA DE RANGO"));
    }
    @Test
    public void checkAddObservaciones(){
        String tplNumber = "250";
        String userName = "user250";
        String value = "0";
        String printerName = "endelp1";
        String observacion = "CAJA DE MEDIDOR ENERGIZADO";
        String userPassword = "1234";
        loginAsUser("admin","1234",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.observacionesButton.clickControl();
        readingActivity.defineObservacion(observacion);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed(observacion));
    }
    @Test
    public void checkAddObservacionesImpedimento(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String observacion = "CASA DESHABITADA";
        String userPassword = "1234";
        loginAsUser("admin","4dm1n.123",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.obervacionesImpedimentoButton.clickControl();
        readingActivity.defineObservacionImpedimento(observacion);
        readingActivity.tabBarControl.selectTabByIndex(2);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed(observacion));
    }

    @Test
    public void checkRegisterLecturasGranDemanda(){
        AndroidDriver driver =(AndroidDriver) Session.getInstance().getDevice();
        String adminUserName = "admin.prueba";
        String adminPasswordName = "ZXCVB";
        String tplNumber = "101";
        String userName = "user101";
        String userPassword = "1234";
        String printerName = "endelp1";
        String value = "0";
        loginAsUser(adminUserName,adminPasswordName,tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingGranDemandaActivity.buscadorButton.clickControl();
        String nroConsumidor = "67026";
        readingGranDemandaActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        ScrollUtils scrollUtils = new ScrollUtils(driver);
        scrollUtils.scrollToControl(readingGranDemandaActivity.cantResetEditText);
        readingGranDemandaActivity.lecturaEditText.setText("1689.28");
        readingGranDemandaActivity.kVarHEditText.setText("1689.28");
        //BLOQUES
        readingGranDemandaActivity.kWHBloqueCEditText.setText("413.54");
        readingGranDemandaActivity.kWHBloqueBEditText.setText("903.75");
        readingGranDemandaActivity.kWHBloqueAEditText.setText("149.83");
        //BLOQUE C
        readingGranDemandaActivity.kWMaxBloqueCEditText.setText("0.658");
        readingGranDemandaActivity.kWHoraMaxBloqueCEditText.setText("2104");
        readingGranDemandaActivity.kWFechaMaxBloqueCEditText.setText("280919");
        //BLOQUE B
        readingGranDemandaActivity.kWMaxBloqueBEditText.setText("0.829");
        readingGranDemandaActivity.kWHoraMaxBloqueBEditText.setText("2351");
        readingGranDemandaActivity.kWFechaMaxBloqueBEditText.setText("250621");
        //BLOQUE A
        readingGranDemandaActivity.kWMaxBloqueAEditText.setText("0.272");
        readingGranDemandaActivity.kWHoraMaxBloqueAEditText.setText("0350");
        readingGranDemandaActivity.kWFechaMaxBloqueAEditText.setText("010614");

        readingGranDemandaActivity.cantResetEditText.setText("3563");
        readingGranDemandaActivity.confirmarButton.clickControl();
        readingActivity.confimarConsumoElevado();
    }
    private List<Lectura> leerDatosCSV(String filePath) throws IOException {
        List<Lectura> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            // Leer la primera línea y eliminar el BOM si existe
            String firstLine = br.readLine();
            if (firstLine != null && firstLine.startsWith("\uFEFF")) {
                firstLine = firstLine.substring(1); // Elimina el BOM
            }

            // Usar un StringReader para reintroducir la primera línea sin BOM
            StringBuilder sb = new StringBuilder();
            sb.append(firstLine).append("\n");

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            // Pasar los datos limpios a CSVParser
            try (Reader reader = new StringReader(sb.toString());
                 CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {

                System.out.println(parser.getHeaderMap().keySet());

                for (CSVRecord record : parser) {
                    String nroConsumidor = record.get("TlxCli");
                    String lectura = record.get("NuevaLectura");
                    lista.add(new Lectura(nroConsumidor, lectura));
                }
            }
        }
        return lista;
    }


}
