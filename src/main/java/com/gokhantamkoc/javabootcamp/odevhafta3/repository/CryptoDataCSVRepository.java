package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		/**String line = "";
		while ((line = bufferedReader.readLine()) != null){
			line.split(",");
			Candle singleCandle = new Candle();
		}*/

		String line = bufferedReader.readLine();
		while (line != null) {
			String[] attributes = line.split(",");
		}
		Candle candle = new Candle();



		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
