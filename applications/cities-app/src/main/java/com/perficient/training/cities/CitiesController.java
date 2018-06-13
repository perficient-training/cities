package com.perficient.training.cities;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType.NUMBER;

@Controller
public class CitiesController {

    private final CityClient cityClient;
    private final ObjectReader csvReader;

    public CitiesController(CityClient cityClient) {
        this.cityClient = cityClient;

        CsvSchema schema = CsvSchema.builder()
                .addColumn("postalCode")
                .addColumn("latitude", NUMBER)
                .addColumn("longitude", NUMBER)
                .addColumn("name")
                .addColumn("stateCode")
                .addColumn("county")
                .build().withHeader();

        csvReader = new CsvMapper().readerFor(CityInfo.class).with(schema);

    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/setup")
    public String setup(@RequestParam("file") MultipartFile uploadFile) throws java.io.IOException {
        // convert CSV entries to list of CityInfo objects
        // for each element in the list call CityClient.add()
        csvToList(uploadFile.getInputStream()).stream().forEach(cityClient::addCity);
        return "redirect:/cities";
    }

    @GetMapping("/cities")
    public String cities(Map<String, Object> model) {
        // get the list of cities from CityClient.getAll()
        List<CityInfo> cities = cityClient.getCities();
        // add the list of cities to the model
        model.put("cities", cities);
        return "cities";
    }

    private List<CityInfo> csvToList(InputStream csvData) throws java.io.IOException {
        List<CityInfo> cities = new ArrayList<>();
        MappingIterator<CityInfo> iterator = csvReader.readValues(csvData);

        while (iterator.hasNext()) {
            cities.add(iterator.nextValue());
        }

        return cities;
    }
}
