package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private Double[][] rawData;
	private Double[][] altData;
	private Double[] addOffset;
	private Double[] multOffset;
	private Double[] expOffset;
	private Double[] deltaE;
	private Double avgDeltaE;
	private Double[] calR;
	private Double[] calG;
	private Double[] calB;
	private Double[] realR;
	private Double[] realG;
	private Double[] realB;
	private Double[] calLStar;
	private Double[] calAStar;
	private Double[] calBStar;
	private Double[] realLStar;
	private Double[] realAStar;
	private Double[] realBStar;
	private Double[] x;
	private Double[] y;
	private Double[] z;
	private Double[] varX;
	private Double[] varY;
	private Double[] varZ;
	private Double[][] xyzToRGB;
	private Double[][] specToXYZ;
	private int numRuns;
	private Double addStep;
	private Double multStep;
	private Double expStep;
	private CalibrationMethod cal = new CalibrationMethod(rawData, altData, addOffset, 
			multOffset, expOffset, deltaE, avgDeltaE, calR, calG, calB, realR, realG, 
			realB, calLStar, calAStar, calBStar, realLStar, realAStar, realBStar, x, 
			y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns, addStep, multStep, expStep);
	public static void main(String[] args) throws FileNotFoundException {
		Double[][] rawData = new Double[1][1];
		Double[][] altData = new Double[1][1];
		Double[] addOffset = new Double[1];
		Double[] multOffset = new Double[1];
		Double[] expOffset = new Double[1];
		Double[] deltaE = new Double[1];
		Double avgDeltaE = 0.0;
		Double[] calR = new Double[1];
		Double[] calG = new Double[1];
		Double[] calB = new Double[1];
		Double[] realR = new Double[1];
		Double[] realG = new Double[1];
		Double[] realB = new Double[1];
		Double[] calLStar = new Double[1];
		Double[] calAStar = new Double[1];
		Double[] calBStar = new Double[1];
		Double[] realLStar = new Double[1];
		Double[] realAStar = new Double[1];
		Double[] realBStar = new Double[1];
		Double[] x = new Double[1];
		Double[] y = new Double[1];
		Double[] z = new Double[1];
		Double[] varX = new Double[1];
		Double[] varY = new Double[1];
		Double[] varZ = new Double[1];
		Double[][] xyzToRGB = new Double[1][1];
		Double[][] specToXYZ = new Double[1][1];
		int numRuns = 0;
		Double addStep = 0.0;
		Double multStep = 0.0;
		Double expStep = 0.0;
		CalibrationMethod cal = new CalibrationMethod(rawData, altData, addOffset, 
				multOffset, expOffset, deltaE, avgDeltaE, calR, calG, calB, realR, realG, 
				realB, calLStar, calAStar, calBStar, realLStar, realAStar, realBStar, x, 
				y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns, addStep, multStep, expStep);
		Main m = new Main(rawData, altData, addOffset, multOffset,
				expOffset, deltaE, avgDeltaE, calR, calG, calR, realR, realG, realB,
				calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
				x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
				addStep, multStep, expStep, cal);
		
		System.out.println("CALIBRATION PROCESS BEGIN");
		
		System.out.println("Initalizing...");
		cal = m.initCal(cal);
		System.out.println("Complete");
		
		System.out.println("Calibrating...");
		for(int i = 0; i < cal.getNumRuns(); i++) {
			cal.setAltData(cal.applyOffsets(cal.getRawData(), cal.getAddOffset(), cal.getMultOffset(), cal.getExpOffset()));
			
			cal.setX(cal.calculateX(cal.getAltData(), cal.getSpecToXYZ()[0]));
			cal.setY(cal.calculateY(cal.getAltData(), cal.getSpecToXYZ()[1]));
			cal.setZ(cal.calculateZ(cal.getAltData(), cal.getSpecToXYZ()[2]));
			
			cal.setVarX(cal.calculateVarX(cal.getX()));
			cal.setVarY(cal.calculateVarY(cal.getY()));
			cal.setVarZ(cal.calculateVarZ(cal.getZ()));
			
			cal.setCalLStar(cal.calculateLStar(cal.getVarY()));			
			cal.setCalAStar(cal.calculateAStar(cal.getVarX(), cal.getVarY()));
			cal.setCalBStar(cal.calculateBStar(cal.getVarY(), cal.getVarZ()));
			
			cal.setCalR(cal.calculateR(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));			
			cal.setCalG(cal.calculateG(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));
			cal.setCalB(cal.calculateB(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));
			
			cal.setDeltaE(cal.calculateDeltaE(cal.getCalLStar(), cal.getCalAStar(), cal.getCalBStar(), cal.getRealLStar(), cal.getRealAStar(), cal.getRealBStar()));
			
			cal.setAvgDeltaE(cal.averageDeltaE(cal.getDeltaE()));
		}
		System.out.println("Complete");

		System.out.println("Printing Results...");
		m.printResults(cal);
		System.out.println("Complete");
		System.out.println("CALIBRATION PROCESS END");
	}
	
	public Main(Double[][] rawData, Double[][] altData, Double[] addOffset, Double[] multOffset, Double[] expOffset,
			Double[] deltaE, Double avgDeltaE, Double[] calR, Double[] calG, Double[] calB, Double[] realR,
			Double[] realG, Double[] realB, Double[] calLStar, Double[] calAStar, Double[] calBStar, Double[] realLStar,
			Double[] realAStar, Double[] realBStar, Double[] x, Double[] y, Double[] z, Double[] varX, Double[] varY,
			Double[] varZ, Double[][] xyzToRGB, Double[][] specToXYZ, int numRuns, Double addStep, Double multStep,
			Double expStep, CalibrationMethod cal) {
		super();
		this.rawData = rawData;
		this.altData = altData;
		this.addOffset = addOffset;
		this.multOffset = multOffset;
		this.expOffset = expOffset;
		this.deltaE = deltaE;
		this.avgDeltaE = avgDeltaE;
		this.calR = calR;
		this.calG = calG;
		this.calB = calB;
		this.realR = realR;
		this.realG = realG;
		this.realB = realB;
		this.calLStar = calLStar;
		this.calAStar = calAStar;
		this.calBStar = calBStar;
		this.realLStar = realLStar;
		this.realAStar = realAStar;
		this.realBStar = realBStar;
		this.x = x;
		this.y = y;
		this.z = z;
		this.varX = varX;
		this.varY = varY;
		this.varZ = varZ;
		this.xyzToRGB = xyzToRGB;
		this.specToXYZ = specToXYZ;
		this.numRuns = numRuns;
		this.addStep = addStep;
		this.multStep = multStep;
		this.expStep = expStep;
		this.cal = cal;
	}

	//Getters
	public Double[][] getRawData() {
		return rawData;
	}
	public Double[][] getAltData() {
		return altData;
	}
	public Double[] getAddOffset() {
		return addOffset;
	}
	public Double[] getMultOffset() {
		return multOffset;
	}
	public Double[] getExpOffset() {
		return expOffset;
	}
	public Double[] getDeltaE() {
		return deltaE;
	}
	public Double getAvgDeltaE() {
		return avgDeltaE;
	}
	public Double[] getCalR() {
		return calR;
	}
	public Double[] getCalG() {
		return calG;
	}
	public Double[] getCalB() {
		return calB;
	}
	public Double[] getRealR() {
		return realR;
	}
	public Double[] getRealG() {
		return realG;
	}
	public Double[] getRealB() {
		return realB;
	}
	public Double[] getCalLStar() {
		return calLStar;
	}
	public Double[] getCalAStar() {
		return calAStar;
	}
	public Double[] getCalBStar() {
		return calBStar;
	}
	public Double[] getRealLStar() {
		return realLStar;
	}
	public Double[] getRealAStar() {
		return realAStar;
	}
	public Double[] getRealBStar() {
		return realBStar;
	}
	public Double[] getX() {
		return x;
	}
	public Double[] getY() {
		return y;
	}
	public Double[] getZ() {
		return z;
	}
	public Double[] getVarX() {
		return varX;
	}
	public Double[] getVarY() {
		return varY;
	}
	public Double[] getVarZ() {
		return varZ;
	}
	public Double[][] getXYZToRGB() {
		return xyzToRGB;
	}
	public Double[][] getSpecToXYZ() {
		return specToXYZ;
	}
	public int getNumRuns() {
		return numRuns;
	}
	public Double getAddStep() {
		return addStep;
	}
	public Double getMultStep() {
		return multStep;
	}
	public Double getExpStep() {
		return expStep;
	}
	public CalibrationMethod getCal() {
		return cal;
	}
	
	//Setters
	public void setRawData(Double[][] rawData) {
		this.rawData = rawData;
	}
	public void setAltData(Double[][] altData) {
		this.altData = altData;
	}
	public void setAddOffset(Double[] addOffset) {
		this.addOffset = addOffset;
	}
	public void setMultOffset(Double[] multOffset) {
		this.multOffset = multOffset;
	}
	public void setExpOffset(Double[] expOffset) {
		this.expOffset = expOffset;
	}
	public void setDeltaE(Double[] deltaE) {
		this.deltaE = deltaE;
	}
	public void setAvgDeltaE(Double avgDeltaE) {
		this.avgDeltaE = avgDeltaE;
	}
	public void setCalR(Double[] calR) {
		this.calR = calR;
	}
	public void setCalG(Double[] calG) {
		this.calG = calG;
	}
	public void setCalB(Double[] calB) {
		this.calB = calB;
	}
	public void setRealR(Double[] realR) {
		this.realR = realR;
	}
	public void setRealG(Double[] realG) {
		this.realG = realG;
	}
	public void setRealB(Double[] realB) {
		this.realB = realB;
	}
	public void setCalLStar(Double[] calLStar) {
		this.calLStar = calLStar;
	}
	public void setCalAStar(Double[] calAStar) {
		this.calAStar = calAStar;
	}
	public void setCalBStar(Double[] calBStar) {
		this.calBStar = calBStar;
	}
	public void setRealLStar(Double[] realLStar) {
		this.realLStar = realLStar;
	}
	public void setRealAStar(Double[] realAStar) {
		this.realAStar = realAStar;
	}
	public void setRealBStar(Double[] realBStar) {
		this.realBStar = realBStar;
	}
	public void setX(Double[] x) {
		this.x = x;
	}
	public void setY(Double[] y) {
		this.y = y;
	}
	public void setZ(Double[] z) {
		this.z = z;
	}
	public void setVarX(Double[] varX) {
		this.varX = varX;
	}
	public void setVarY(Double[] varY) {
		this.varY = varY;
	}
	public void setVarZ(Double[] varZ) {
		this.varZ = varZ;
	}
	public void setXYZToRGB(Double[][] xyzToRGB) {
		this.xyzToRGB = xyzToRGB;
	}
	public void setSpecToXYZ(Double[][] specToXYZ) {
		this.specToXYZ = specToXYZ;
	}
	public void setNumRuns(int numRuns) {
		this.numRuns = numRuns;
	}
	public void setAddStep(Double addStep) {
		this.addStep = addStep;
	}
	public void setMultStep(Double multStep) {
		this.multStep = multStep;
	}
	public void setExpStep(Double expStep) {
		this.expStep = expStep;
	}
	public void setCal(CalibrationMethod cal) {
		this.cal = cal;
	}

	public Double[][] readCSV(File CSV, int height, int width) throws FileNotFoundException{
		Double[][] data = new Double[height][width];
		ArrayList<ArrayList<String>> dataList = new ArrayList<>();
		try (Scanner scanner = new Scanner(CSV);) {
		    while (scanner.hasNextLine()) {
		        dataList.add(getDataFromLine(scanner.nextLine()));
		    }
		}
		
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				data[i][j] = (Double) Double.parseDouble(dataList.get(i).get(j));
				//System.out.print(data[i][j] + " ");
			}
			//System.out.println();
		}
		
		return data;
	}
	
	public ArrayList<String> getDataFromLine(String line) {
	    ArrayList<String> data = new ArrayList<String>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	            data.add(rowScanner.next());
	        }
	    }
	    return data;
	}
	
	public Double[] convertTo1D(Double[][] data) {
		Double[] values = new Double[data[0].length];
		for(int i = 0; i < values.length; i++) {
			values[i] = data[0][i];
		}
		return values;
	}
	
	public CalibrationMethod readUserInput(CalibrationMethod cal) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter raw data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		String filePath = sc.nextLine();
		
		System.out.println("Enter number of samples ");
		int height = sc.nextInt();
		sc.nextLine();
		
		int width = 14;
		
		if(height == 2) {
			width = 2;
		}
		
		File rawData = new File(filePath);
		cal.setRawData(readCSV(rawData, height, width));
				
		System.out.println("Enter real CIEL data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		String filePath1 = sc.nextLine();
		File realLStar = new File(filePath1);

		cal.setRealLStar(convertTo1D(readCSV(realLStar, 1, height)));
		
		System.out.println("Enter real CIEA data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		File realAStar = new File(filePath);
		cal.setRealAStar(convertTo1D(readCSV(realAStar, 1, height)));
		
		System.out.println("Enter real CIEB data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		File realBStar = new File(filePath);
		cal.setRealBStar(convertTo1D(readCSV(realBStar, 1, height)));
		
		System.out.println("Enter real R data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		File realR = new File(filePath);
		cal.setRealR(convertTo1D(readCSV(realR, 1, height)));
		
		System.out.println("Enter real G data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		File realG = new File(filePath);
		cal.setRealG(convertTo1D(readCSV(realG, 1, height)));
		
		System.out.println("Enter real B data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		File realB = new File(filePath);
		cal.setRealB(convertTo1D(readCSV(realB, 1, height)));
		
		System.out.println("Enter number of runs: ");
		cal.setNumRuns(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter addition step: ");
		cal.setAddStep(sc.nextDouble());
		sc.nextLine();

		System.out.println("Enter multiplication step: ");
		cal.setMultStep(sc.nextDouble());
		sc.nextLine();

		System.out.println("Enter exponent step: ");
		cal.setExpStep(sc.nextDouble());
		sc.nextLine();
		
		sc.close();
		return cal;
	}
	
	public CalibrationMethod initCal(CalibrationMethod cal) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		Double[] addOff = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		Double[] multOff = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		Double[] expOff = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		
		cal.setAddOffset(addOff);
		cal.setMultOffset(multOff);
		cal.setExpOffset(expOff);
		
		File xyzToRGB = new File("Z:\\PMFI Grant\\Grease Monkey\\Colorimeter Calibration\\src\\src\\XYZToRGB.csv");
		cal.setXYZToRGB(readCSV(xyzToRGB, 3, 3));
		
		File specToXYZ = new File("Z:\\PMFI Grant\\Grease Monkey\\Colorimeter Calibration\\src\\src\\SpectrumToXYZ.csv");
		cal.setSpecToXYZ(readCSV(specToXYZ, 3, 14));
		
		readUserInput(cal);
		
		sc.close();
		return cal;
	}
	
	public void printResults(CalibrationMethod cal) {
		System.out.println("Results:");
		for(Double[] data : cal.getAltData()) {
			System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
			for(Double val : data) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		System.out.println("Add:");
		System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
		for(Double val : cal.getAddOffset()) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		System.out.println("Mult:");
		System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
		for(Double val : cal.getMultOffset()) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		System.out.println("Exp:");
		System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
		for(Double val : cal.getExpOffset()) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		System.out.println("CIELAB:");
		System.out.println("L, A, B:");
		for(int i = 0; i < cal.getCalLStar().length; i++) {
			int num = i + 1;
			System.out.println("	Sample " + num + ": " + cal.getCalLStar()[i] + ", " + cal.getCalAStar()[i] + ", " + cal.getCalBStar()[i] );
		}
		
		System.out.println("RGB:");
		System.out.println("R, G, B:");
		for(int i = 0; i < cal.getCalR().length; i++) {
			int num = i + 1;
			System.out.println("	Sample " + num + ": " + cal.getCalR()[i] + ", " + cal.getCalG()[i] + ", " + cal.getCalB()[i] );
		}
		
		System.out.println("Delta E:");
		int count = 0;
		for(Double val : cal.getDeltaE()) {
			count++;
			System.out.println("	Sample " + count + ": " + val);
		}
		
		System.out.println("Average Delta E: " + cal.getAvgDeltaE());
	}
	
}
