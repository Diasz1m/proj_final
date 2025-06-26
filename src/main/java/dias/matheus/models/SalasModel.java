package dias.matheus.models;

import dias.matheus.classes.Sala;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    private String listarSalas() {
        try {
            Path path = Paths.get("salas.json");
            if (!Files.exists(path)) {
                return "[]"; // Retorna JSON vazio se arquivo não existir
            }
            return Files.readString(path);
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String buscarSalaPorId(String arquivo, int id) {
        try {
            String json = Files.readString(Paths.get(arquivo));
            json = json.trim();
            if (json.startsWith("[")) json = json.substring(1);
            if (json.endsWith("]")) json = json.substring(0, json.length() - 1);

            String[] salas = json.split("\\},\\s*\\{");
            for (String sala : salas) {
                if (!sala.startsWith("{")) sala = "{" + sala;
                if (!sala.endsWith("}")) sala = sala + "}";

                // Busca pelo id
                String busca = "\"id\": " + id;
                if (sala.contains(busca)) {
                    return sala;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String reservarSala(Long salaId)
    {

        try {
            if()
        }
    }
}
