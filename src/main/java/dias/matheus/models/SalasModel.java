package dias.matheus.models;

import dias.matheus.classes.Sala;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SalasModel {

    public SalasModel() {}

    private String cadastrarSala(Sala sala)
    {
//        String json = "{\n" +
//                "  \"ID\":  " + sala.getId() + ",\n" +
//                "  \"nome\":  " + sala.getNome() + ",\n" +
//                "  \"capacidade\": " + sala.getCapacidade() + "}";

        String json = sala.toString();

        try (FileWriter file = new FileWriter("salas.json")){
            file.write(json);

        } catch (Exception $e) {}
        return json;
    }

    private String listarSalas(List<Sala> salas) {
        try (String data = Files.readString(Paths.get("salas.json"))) {
            return data;
        }catch (IOException e) {
            throw new RuntimeException(e);
        } {}
    }
}
