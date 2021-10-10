package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PrimaryData {
    private List<Data> data;
    private int count = -1;

    public PrimaryData(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;
                else if (count != -1)
                    data.add(new Data(line));
                else
                    count = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (count == -1)
            throw new RuntimeException("");
    }

    public int getCount() {
        return count;
    }

    public List<Data> getData() {
        return data;
    }
}