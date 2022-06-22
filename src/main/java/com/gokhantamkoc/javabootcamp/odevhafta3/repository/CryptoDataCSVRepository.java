package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

import static com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils.convertToDate;

public class CryptoDataCSVRepository implements CSVRepository {

	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String line;
		int iteration = 0;
		while ((line = bufferedReader.readLine()) != null) { //her bir satırı okuyan while döngüsü.
			String[] values = line.split(COMMA_DELIMITER); //her bir satırın değerlerini ayrıştıran dizi.
			if (iteration == 0) { //ilk satır header olduğu için atlamak gerekir. Bu yüzden burada kontrol yapıyoruz.
				iteration++;
				continue;
			}
				candles.add(new Candle(Long.parseLong(values[0]),
						Double.parseDouble(values[3]), Double.parseDouble(values[4]),
						Double.parseDouble(values[5]), Double.parseDouble(values[6]),
						Double.parseDouble(values[7])));
		}
		bufferedReader.close();
		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
