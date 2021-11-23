package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
many of the methods used within this file use the object type calibration method
for more information refer to the calibration method files
the code is further explained in the associated documents on the Z drive
any questions can be referred to Zach Redcay
a working version is saved within the https://github.com/zredcay/Colorimeter-Calibration
Github Repo, to ensure version control any changes should be reviewed before 
being committed and pushed to the repo
*/
public class Main {
	//Variables
	
	//Data vars
	private Double[][] rawData;
	private Double[][] altData;
	
	//Offset vars
	private Double[] addOffset;
	private Double[] multOffset;
	private Double[] expOffset;
	
	//Delta E/RGB vars
	private Double[] deltaE;
	private Double[][] deltaRGB;
	private Double avgDeltaE;
	
	//RGB vals
	private Double[] maxRGB;
	private Double[] calR;
	private Double[] calG;
	private Double[] calB;
	private Double[] realR;
	private Double[] realG;
	private Double[] realB;
	
	//CIELAB vars
	private Double[] calLStar;
	private Double[] calAStar;
	private Double[] calBStar;
	private Double[] realLStar;
	private Double[] realAStar;
	private Double[] realBStar;
	
	//XYZ vars
	private Double[] x;
	private Double[] y;
	private Double[] z;
	private Double[] varX;
	private Double[] varY;
	private Double[] varZ;
	
	//conversion tables
	private Double[][] xyzToRGB;
	private Double[][] specToXYZ;
	
	//run counter
	private int numRuns;
	
	//calibration step vars
	private Double addStep;
	private Double multStep;
	private Double expStep;
	
	//calibration method object
	private CalibrationMethod cal = new CalibrationMethod(rawData, altData, addOffset, 
			multOffset, expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calB, realR, realG, 
			realB, calLStar, calAStar, calBStar, realLStar, realAStar, realBStar, x, 
			y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns, addStep, multStep, expStep);
	
	//Methods
	
	//main function
	public static void main(String[] args) throws FileNotFoundException {
		//method throws exception if file is not found
		
		//vars to construct calibration method and main objects
		Double[][] rawData = new Double[1][1];
		Double[][] altData = new Double[1][1];
		Double[] addOffset = new Double[1];
		Double[] multOffset = new Double[1];
		Double[] expOffset = new Double[1];
		Double[] deltaE = new Double[1];
		Double[][] deltaRGB = new Double[1][1];
		Double avgDeltaE = 0.0;
		Double[] maxRGB = new Double[1];
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
		
		//create calibration method object
		CalibrationMethod cal = new CalibrationMethod(rawData, altData, addOffset, 
				multOffset, expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calB, realR, realG, 
				realB, calLStar, calAStar, calBStar, realLStar, realAStar, realBStar, x, 
				y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns, addStep, multStep, expStep);
		
		//create main object
		Main m = new Main(rawData, altData, addOffset, multOffset,
				expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calR, realR, realG, realB,
				calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
				x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
				addStep, multStep, expStep, cal);
		
		//print progress marker
		System.out.println("CALIBRATION PROCESS BEGIN");
		
		//initialize the calibration method object
		System.out.println("Initalizing...");
		cal = m.initCal(cal);
		
		//print progress marker
		System.out.println("Complete");
		
		//print progress marker
		System.out.println("Calibrating...");
		
		//calibrate data set as many times as the user input
		for(int i = 0; i < cal.getNumRuns(); i++) {
			//print the run number for a progress marker
			System.out.println("Run " + i);
			
			//adjust and set the Mult Offset
			cal.setMultOffset(cal.adjustMultOffsets(cal.getAddOffset(), cal.getMultOffset(), 
					cal.getExpOffset(), cal.getAvgDeltaE(), cal.getRawData(), cal.getMultStep(), 
					cal.getSpecToXYZ(), cal.getRealLStar(), cal.getRealAStar(), cal.getRealBStar()));
			
			//print progress marker
			System.out.println("Mult Calibrated");
			
			//adjust and set the Add Offset
			cal.setAddOffset(cal.adjustAddOffsets(cal.getAddOffset(), cal.getMultOffset(), 
					cal.getExpOffset(), cal.getAvgDeltaE(), cal.getRawData(), cal.getMultStep(), 
					cal.getSpecToXYZ(), cal.getRealLStar(), cal.getRealAStar(), cal.getRealBStar()));
			
			//print progress marker
			System.out.println("Add Calibrated");
			
			//adjust and set the Exp Offset
			cal.setExpOffset(cal.adjustExpOffsets(cal.getAddOffset(), cal.getMultOffset(), 
					cal.getExpOffset(), cal.getAvgDeltaE(), cal.getRawData(), cal.getMultStep(), 
					cal.getSpecToXYZ(), cal.getRealLStar(), cal.getRealAStar(), cal.getRealBStar()));
			
			//print the progress marker
			System.out.println("Exp Calibrated");
			
			//apply the offsets and set the Alt Data
			cal.setAltData(cal.applyOffsets(cal.getRawData(), cal.getAddOffset(), cal.getMultOffset(), cal.getExpOffset()));
			
			//calculate and set the new XYZ
			cal.setX(cal.calculateX(cal.getAltData(), cal.getSpecToXYZ()[0]));
			cal.setY(cal.calculateY(cal.getAltData(), cal.getSpecToXYZ()[1]));
			cal.setZ(cal.calculateZ(cal.getAltData(), cal.getSpecToXYZ()[2]));
			
			//calculate and set the new VARXYZ
			cal.setVarX(cal.calculateVarX(cal.getX()));
			cal.setVarY(cal.calculateVarY(cal.getY()));
			cal.setVarZ(cal.calculateVarZ(cal.getZ()));
			
			//calculate and set the new CIELAB
			cal.setCalLStar(cal.calculateLStar(cal.getVarY()));			
			cal.setCalAStar(cal.calculateAStar(cal.getVarX(), cal.getVarY()));
			cal.setCalBStar(cal.calculateBStar(cal.getVarY(), cal.getVarZ()));
			
			//calculate and set the new RGB
			cal.setCalR(cal.calculateR(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));			
			cal.setCalG(cal.calculateG(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));
			cal.setCalB(cal.calculateB(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));
			
			//calculate and set the new max RGB
			cal.setMaxRGB(cal.calculateMaxRGB(cal.getMaxRGB(), cal.getCalR(), cal.getCalG(), cal.getCalB()));			
			
			//scale and set the new RGB
			cal.setCalR(cal.scaleRGB(cal.getMaxRGB(), cal.getCalR()));			
			cal.setCalG(cal.scaleRGB(cal.getMaxRGB(), cal.getCalG()));
			cal.setCalB(cal.scaleRGB(cal.getMaxRGB(), cal.getCalB()));
			
			//calculate and set the new Delta RGB
			cal.setDeltaRGB(cal.calculateDeltaRGB(cal.getCalR(), cal.getCalG(), cal.getCalB(), cal.getRealR(), cal.getRealG(), cal.getRealB()));
			
			//calculate and set the new Delta E
			cal.setDeltaE(cal.calculateDeltaE(cal.getCalLStar(), cal.getCalAStar(), cal.getCalBStar(), cal.getRealLStar(), cal.getRealAStar(), cal.getRealBStar()));
			
			//average and set the new Average Delta E
			cal.setAvgDeltaE(cal.averageDeltaE(cal.getDeltaE()));
		}
		
		//print progress marker
		System.out.println("Complete");

		//print results
		System.out.println("Printing Results...");
		m.printResults(cal);
		
		//print progress marker
		System.out.println("Complete");
		
		//print progress marker
		System.out.println("CALIBRATION PROCESS END");
	}
	
	//constructor
	public Main(Double[][] rawData, Double[][] altData, Double[] addOffset, Double[] multOffset, Double[] expOffset,
			Double[] deltaE, Double[][] deltaRGB, Double avgDeltaE, Double[] maxRGB, Double[] calR, Double[] calG, Double[] calB, Double[] realR,
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
		this.deltaRGB = deltaRGB;
		this.avgDeltaE = avgDeltaE;
		this.maxRGB = maxRGB;
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
	public Double[][] getDeltaRGB() {
		return deltaRGB;
	}
	public Double getAvgDeltaE() {
		return avgDeltaE;
	}
	public Double[] getMaxRGB() {
		return maxRGB;
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
	public void setDeltaRGB(Double[][] deltaRGB) {
		this.deltaRGB = deltaRGB;
	}
	public void setAvgDeltaE(Double avgDeltaE) {
		this.avgDeltaE = avgDeltaE;
	}
	public void setMaxRGB(Double[] maxRGB) {
		this.maxRGB = maxRGB;
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

	//CSV methods
	public Double[][] readCSV(File CSV, int height, int width) throws FileNotFoundException{
		//throw exception if the file cant be found
		//create local vars for the results
		Double[][] data = new Double[height][width];
		ArrayList<ArrayList<String>> dataList = new ArrayList<>();
		
		//try to make a scanner using the file passed in
		try (Scanner scanner = new Scanner(CSV);) {
			//while there are more lines add them to the data list
		    while (scanner.hasNextLine()) {
		        dataList.add(getDataFromLine(scanner.nextLine()));
		    }
		}
		
		//for every entry in the table parse the value
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				data[i][j] = (Double) Double.parseDouble(dataList.get(i).get(j));
			}
		}
		
		return data;
	}
	
	public ArrayList<String> getDataFromLine(String line) {
		//create local var for the results
	    ArrayList<String> data = new ArrayList<String>();
	    
	    //try to create a scanner using the line passed in
	    try (Scanner rowScanner = new Scanner(line)) {
	    	//divide data by commas
	        rowScanner.useDelimiter(",");
	        
	        //while there is info in the line add to the data set
	        while (rowScanner.hasNext()) {
	            data.add(rowScanner.next());
	        }
	    }
	    return data;
	}
	
	//Conversion method
	public Double[] convertTo1D(Double[][] data) {
		//this method is used to convert 2D arrays to 1D, it only works for data 
		//that is originally 1D
		
		//create local var for results
		Double[] values = new Double[data[0].length];
		
		//for every val in the array place in the values array
		for(int i = 0; i < values.length; i++) {
			values[i] = data[0][i];
		}
		return values;
	}
	
	//Initialization methods
	public CalibrationMethod readUserInput(CalibrationMethod cal) throws FileNotFoundException {
		//create scanner to read info from user
		Scanner sc = new Scanner(System.in);
		
		//ask for raw data file 
		System.out.println("Enter raw data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		String filePath = sc.nextLine();
		
		//ask for number of samples
		System.out.println("Enter number of samples ");
		int height = sc.nextInt();
		sc.nextLine();
		
		//width is always 14 as there are 14 spectrum buckets
		int width = 14;
		
		//only for testing purposes
		if(height == 2) {
			width = 2;
		}
		
		//create a file using the user inputed file path, set the raw data var
		File rawData = new File(filePath);
		cal.setRawData(readCSV(rawData, height, width));
				
		//ask for the CIEL file path
		System.out.println("Enter real CIEL data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		String filePath1 = sc.nextLine();
		
		//create a file using the user inputed file path and set real CIEL var
		File realLStar = new File(filePath1);
		cal.setRealLStar(convertTo1D(readCSV(realLStar, 1, height)));
		
		//ask for the CIEA file path
		System.out.println("Enter real CIEA data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		
		//create a file using the user inputed file path and set real CIEA var
		File realAStar = new File(filePath);
		cal.setRealAStar(convertTo1D(readCSV(realAStar, 1, height)));
		
		//ask for the CIEB file path
		System.out.println("Enter real CIEB data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		
		//create a file using the user inputed file path and set real CIEB var
		File realBStar = new File(filePath);
		cal.setRealBStar(convertTo1D(readCSV(realBStar, 1, height)));
		
		//ask for the R file path
		System.out.println("Enter real R data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		
		//create a file using the user inputed file path and set real R var
		File realR = new File(filePath);
		cal.setRealR(convertTo1D(readCSV(realR, 1, height)));
		
		//ask for the G file path
		System.out.println("Enter real G data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		
		//create a file using the user inputed file path and set real G var
		File realG = new File(filePath);
		cal.setRealG(convertTo1D(readCSV(realG, 1, height)));
		
		//ask for the B file path
		System.out.println("Enter real B data file path (Z:\\PMFI Grant\\CalDemo.csv): ");
		filePath = sc.nextLine();
		
		//create a file using the user inputed file path and set real B var
		File realB = new File(filePath);
		cal.setRealB(convertTo1D(readCSV(realB, 1, height)));
		
		//set maxRGB to 0 based on number of samples
		Double[] maxRGB = new Double[height];
		for(int i = 0; i < maxRGB.length; i++) {
			maxRGB[i] = 0.0;			
		}
		cal.setMaxRGB(maxRGB);
		
		//ask for the number of runs and set var
		System.out.println("Enter number of runs: ");
		cal.setNumRuns(sc.nextInt());
		sc.nextLine();
		
		//ask for the add step and set var
		System.out.println("Enter addition step: ");
		cal.setAddStep(sc.nextDouble());
		sc.nextLine();

		//ask for the mult step and set var
		System.out.println("Enter multiplication step: ");
		cal.setMultStep(sc.nextDouble());
		sc.nextLine();

		//ask for the exp step and set var
		System.out.println("Enter exponent step: ");
		cal.setExpStep(sc.nextDouble());
		sc.nextLine();
		
		//close scanner
		sc.close();
		
		return cal;
	}
	
	public CalibrationMethod initCal(CalibrationMethod cal) throws FileNotFoundException{
		//throw exception if the file cant be found
		
		//set XYZToRGB conversion table		
		File xyzToRGB = new File("Z:\\PMFI Grant\\Grease Monkey\\Colorimeter Calibration\\src\\src\\XYZToRGB.csv");
		cal.setXYZToRGB(readCSV(xyzToRGB, 3, 3));
		
		//set SpecToXYZ conversion table
		File specToXYZ = new File("Z:\\PMFI Grant\\Grease Monkey\\Colorimeter Calibration\\src\\src\\SpectrumToXYZ.csv");
		cal.setSpecToXYZ(readCSV(specToXYZ, 3, 14));
		
		//get the user input
		readUserInput(cal);
		
		//create vars for setting the mult offset
		Double[] addOff = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		Double[] multOff = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		Double[] expOff = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		Double temp = 0.0;
		
		//for each data point compare to the associated mult offset, set the 
		//offset to the lowest value
		for(int i = 0; i < cal.getRawData().length; i++) {
			for(int j = 0; j < cal.getRawData()[0].length; j++) {
				temp = 1 / cal.getRawData()[i][j];
				if(multOff[j] > temp) {
					multOff[j] = temp;
				}
			}
		}
		
		//initialize the offsets
		cal.setAddOffset(addOff);
		cal.setMultOffset(multOff);
		cal.setExpOffset(expOff);
		
		//initialize the alt data var
		cal.setAltData(cal.applyOffsets(cal.getRawData(), cal.getAddOffset(), cal.getMultOffset(), cal.getExpOffset()));
		
		//initialize the XYZ vars
		cal.setX(cal.calculateX(cal.getAltData(), cal.getSpecToXYZ()[0]));
		cal.setY(cal.calculateY(cal.getAltData(), cal.getSpecToXYZ()[1]));
		cal.setZ(cal.calculateZ(cal.getAltData(), cal.getSpecToXYZ()[2]));
		
		//initialize the VARXYZ vars
		cal.setVarX(cal.calculateVarX(cal.getX()));
		cal.setVarY(cal.calculateVarY(cal.getY()));
		cal.setVarZ(cal.calculateVarZ(cal.getZ()));
		
		//initialize the CIELAB vars
		cal.setCalLStar(cal.calculateLStar(cal.getVarY()));			
		cal.setCalAStar(cal.calculateAStar(cal.getVarX(), cal.getVarY()));
		cal.setCalBStar(cal.calculateBStar(cal.getVarY(), cal.getVarZ()));
		
		//initialize the RGB vars, unscaled
		cal.setCalR(cal.calculateR(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));			
		cal.setCalG(cal.calculateG(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));
		cal.setCalB(cal.calculateB(cal.getXYZToRGB(), cal.getX(), cal.getY(), cal.getZ()));
		
		//initialize the maxRGB
		cal.setMaxRGB(cal.calculateMaxRGB(cal.getMaxRGB(), cal.getCalR(), cal.getCalG(), cal.getCalB()));			
		
		//initialize the RGB vars, scaled
		cal.setCalR(cal.scaleRGB(cal.getMaxRGB(), cal.getCalR()));			
		cal.setCalG(cal.scaleRGB(cal.getMaxRGB(), cal.getCalG()));
		cal.setCalB(cal.scaleRGB(cal.getMaxRGB(), cal.getCalB()));
		
		//initialize the delta RGB var
		cal.setDeltaRGB(cal.calculateDeltaRGB(cal.getCalR(), cal.getCalG(), cal.getCalB(), cal.getRealR(), cal.getRealG(), cal.getRealB()));
		
		//initialize the delta e var
		cal.setDeltaE(cal.calculateDeltaE(cal.getCalLStar(), cal.getCalAStar(), cal.getCalBStar(), cal.getRealLStar(), cal.getRealAStar(), cal.getRealBStar()));
		
		//initialize average delta e var
		cal.setAvgDeltaE(cal.averageDeltaE(cal.getDeltaE()));
		
		return cal;
	}
	
	//Print method
	public void printResults(CalibrationMethod cal) {
		//print results
		System.out.println("Results:");
		
		//set decimal format for data
		DecimalFormat dataDF = new DecimalFormat("####.##");
		
		//for every value in the Alt Data set, print
		for(Double[] data : cal.getAltData()) {
			System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
			for(Double val : data) {
				System.out.print(dataDF.format(val) + " ");
			}
			System.out.println();
		}
		
		//print add offsets
		System.out.println("Add:");
		System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
		
		//set decimal format for add offsets
		DecimalFormat addDF = new DecimalFormat("####.##");
		
		//for every value in the add offset, print
		for(Double val : cal.getAddOffset()) {
			System.out.print(addDF.format(val) + " ");
		}
		System.out.println();
		
		//print mult offsets
		System.out.println("Mult:");
		System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
		
		//set decimal format for mult offsets
		DecimalFormat multDF = new DecimalFormat("####.####");
		
		//for every value in the mult offset, print
		for(Double val : cal.getMultOffset()) {
			System.out.print(multDF.format(val) + " ");
		}
		System.out.println();
		
		//print exp offsets
		System.out.println("Exp:");
		System.out.println("A, B, C, D, E, F, H, I, J, R, S, T, U:");
		
		//set decimal format for exp offsets
		DecimalFormat expDF = new DecimalFormat("####.##");
		
		//for every value in the exp offset, print
		for(Double val : cal.getExpOffset()) {
			System.out.print(expDF.format(val) + " ");
		}
		System.out.println();
		
		//print XYZ vars
		System.out.println("XYZ:");
		System.out.println("X, Y, Z:");
		
		//set decimal format for XYZ vars
		DecimalFormat xyzDF = new DecimalFormat("####.##");
		
		//for every XYZ value, print
		for(int i = 0; i < cal.getX().length; i++) {
			int num = i + 1;
			System.out.println("	Sample " + num + ": " + xyzDF.format(cal.getX()[i]) + ", " + xyzDF.format(cal.getY()[i]) + ", " + xyzDF.format(cal.getZ()[i]));
		}
		
		//print CIELAB vars
		System.out.println("CIELAB:");
		System.out.println("L, A, B:");
		
		//set decimal format for CIELAB vars
		DecimalFormat labDF = new DecimalFormat("####.##");
		
		//for every CIELAB value, print
		for(int i = 0; i < cal.getCalLStar().length; i++) {
			int num = i + 1;
			System.out.println("	Sample " + num + ": " + labDF.format(cal.getCalLStar()[i]) + ", " + labDF.format(cal.getCalAStar()[i]) + ", " + labDF.format(cal.getCalBStar()[i]));
		}
		
		//print RGB vars
		System.out.println("RGB:");
		System.out.println("R, G, B:");
		
		//set decimal format for RGB vars
		DecimalFormat rgbDF = new DecimalFormat("####.##");
		
		//for every RGB value, print
		for(int i = 0; i < cal.getCalR().length; i++) {
			int num = i + 1;
			System.out.println("	Sample " + num + ": " + rgbDF.format(cal.getCalR()[i]) + ", " + rgbDF.format(cal.getCalG()[i]) + ", " + rgbDF.format(cal.getCalB()[i]));
		}
		
		//print the Delta RGB var
		System.out.println("Delta RGB:");
		System.out.println("R, G, B:");
		
		//set decimal format for the delta RGB var
		DecimalFormat deltaRGBDF = new DecimalFormat("####.##");
		
		//for every delta RGB value, print
		for(int i = 0; i < cal.getDeltaRGB().length; i++) {
			int num = i + 1;
			System.out.println("	Sample " + num + ": " + deltaRGBDF.format(cal.getDeltaRGB()[i][0]) + ", " + deltaRGBDF.format(cal.getDeltaRGB()[i][1]) + ", " + deltaRGBDF.format(cal.getDeltaRGB()[i][2]));
		}
		
		//print delta e
		System.out.println("Delta E:");
		
		//set the decimal format for the delta e var
		DecimalFormat deDF = new DecimalFormat("####.##");
		int count = 0;
		
		//for every delta e value, print
		for(Double val : cal.getDeltaE()) {
			count++;
			System.out.println("	Sample " + count + ": " + deDF.format(val));
		}
		
		//print average delta e
		System.out.println("Average Delta E: " + deDF.format(cal.getAvgDeltaE()));
	}
}
