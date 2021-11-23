package src;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;

//Test should be run individually as when run simultaneously certain tests will 
//fail. They do pass when run one at a time. 
class MainTest {
	private Double[][] rawData;
	private Double[][] altData;
	private Double[] addOffset;
	private Double[] multOffset;
	private Double[] expOffset;
	private Double[] deltaE;
	private Double[][] deltaRGB;
	private Double avgDeltaE;
	private Double[] calR;
	private Double[] calG;
	private Double[] calB;
	private Double[] realR;
	private Double[] realG;
	private Double[] realB;
	private Double[] maxRGB;
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
	private CalibrationMethod calMeth = new CalibrationMethod(rawData, altData, addOffset, multOffset,
			expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calB, realR, realG, realB,
			calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
			x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
			addStep, multStep, expStep);
	private Main main = new Main(rawData, altData, addOffset, multOffset,
			expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calR, realR, realG, realB,
			calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
			x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
			addStep, multStep, expStep, calMeth);
	
	@Before
	public void setUp() {
		rawData = new Double[1][1];
		rawData[0][0] = 1.0;
		altData = new Double[1][1];
		altData[0][0] = 1.0;
		addOffset = new Double[1];
		addOffset[0] = 1.0;
		multOffset = new Double[1];
		multOffset[0] = 1.0;
		expOffset = new Double[1];
		expOffset[0] = 1.0;
		deltaE = new Double[1];
		deltaE[0] = 1.0;
		deltaRGB = new Double[1][1];
		deltaRGB[0][0] = 1.0;
		avgDeltaE = 1.0;
		maxRGB = new Double[1];
		maxRGB[0] = 1.0;
		calR = new Double[1];
		calR[0] = 1.0;
		calG = new Double[1];
		calG[0] = 1.0;
		calB = new Double[1];
		calB[0] = 1.0;
		realR = new Double[1];
		realR[0] = 1.0;
		realG = new Double[1];
		realG[0] = 1.0;
		realB = new Double[1];
		realB[0] = 1.0;
		calLStar = new Double[1];
		calLStar[0] = 1.0;
		calAStar = new Double[1];
		calAStar[0] = 1.0;
		calBStar = new Double[1];
		calBStar[0] = 1.0;
		realLStar = new Double[1];
		realLStar[0] = 1.0;
		realAStar = new Double[1];
		realAStar[0] = 1.0;
		realBStar = new Double[1];
		realBStar[0] = 1.0;
		x = new Double[1];
		x[0] = 1.0;
		y = new Double[1];
		y[0] = 1.0;
		z = new Double[1];
		z[0] = 1.0;
		varX = new Double[1];
		varX[0] = 1.0;
		varY = new Double[1];
		varY[0] = 1.0;
		varZ = new Double[1];
		varZ[0] = 1.0;
		xyzToRGB = new Double[1][1];
		xyzToRGB[0][0] = 1.0;
		specToXYZ = new Double[1][1];
		specToXYZ[0][0] = 1.0;
		numRuns = 3;
		addStep = 1.0;
		multStep = 1.0;
		expStep = 1.0;
		calMeth = new CalibrationMethod(rawData, altData, addOffset, multOffset,
				expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calR, realR, realG, realB,
				calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
				x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
				addStep, multStep, expStep);
		main = new Main(rawData, altData, addOffset, multOffset,
				expOffset, deltaE, deltaRGB, avgDeltaE, maxRGB, calR, calG, calR, realR, realG, realB,
				calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
				x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
				addStep, multStep, expStep, calMeth);
	}

	@Test
	public void testGetAndSet() {
		Double [][] testRawData = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		main.setRawData(testRawData);
		assertTrue(Arrays.deepEquals(main.getRawData(), testRawData));
		
		Double [][] testAltData = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		main.setAltData(testAltData);
		assertTrue(Arrays.deepEquals(main.getAltData(), testAltData));
		
		Double[] testAddOffset = {0.0, 0.0, 0.0};
		main.setAddOffset(testAddOffset);
		assertTrue(Arrays.deepEquals(main.getAddOffset(), testAddOffset));
		
		Double[] testMultOffset = {0.0, 0.0, 0.0};
		main.setMultOffset(testMultOffset);
		assertTrue(Arrays.deepEquals(main.getMultOffset(), testMultOffset));
		
		Double[] testExpOffset = {0.0, 0.0, 0.0};
		main.setExpOffset(testExpOffset);
		assertTrue(Arrays.deepEquals(main.getExpOffset(), testExpOffset));
		
		Double[] testDeltaE = {0.0, 0.0, 0.0};
		main.setDeltaE(testDeltaE);
		assertTrue(Arrays.deepEquals(main.getDeltaE(), testDeltaE));
		
		Double[][] testDeltaRGB = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		calMeth.setDeltaRGB(testDeltaRGB);
		assertTrue(Arrays.deepEquals(calMeth.getDeltaRGB(), testDeltaRGB));
		
		Double testAvgDeltaE = 0.0; 
		main.setAvgDeltaE(testAvgDeltaE);
		assertEquals(main.getAvgDeltaE(), testAvgDeltaE);
		
		Double[] testMaxRGB = {0.0, 0.0, 0.0};
		main.setMaxRGB(testMaxRGB);
		assertTrue(Arrays.deepEquals(main.getMaxRGB(), testMaxRGB));
		
		Double[] testCalR = {0.0, 0.0, 0.0};
		main.setCalR(testCalR);
		assertTrue(Arrays.deepEquals(main.getCalR(), testCalR));
		
		Double[] testCalG = {0.0, 0.0, 0.0};
		main.setCalG(testCalG);
		assertTrue(Arrays.deepEquals(main.getCalG(), testCalG));
		
		Double[] testCalB = {0.0, 0.0, 0.0};
		main.setCalB(testCalB);
		assertTrue(Arrays.deepEquals(main.getCalB(), testCalB));
		
		Double[] testRealR = {0.0, 0.0, 0.0};
		main.setRealR(testRealR);
		assertTrue(Arrays.deepEquals(main.getRealR(), testRealR));
		
		Double[] testRealG = {0.0, 0.0, 0.0};
		main.setRealG(testRealG);
		assertTrue(Arrays.deepEquals(main.getRealG(), testRealG));
		
		Double[] testRealB = {0.0, 0.0, 0.0};
		main.setRealB(testRealB);
		assertTrue(Arrays.deepEquals(main.getRealB(), testRealB));
		
		Double[] testCalLStar = {0.0, 0.0, 0.0};
		main.setCalLStar(testCalLStar);
		assertTrue(Arrays.deepEquals(main.getCalLStar(), testCalLStar));
		
		Double[] testCalAStar = {0.0, 0.0, 0.0};
		main.setCalAStar(testCalAStar);
		assertTrue(Arrays.deepEquals(main.getCalAStar(), testCalAStar));
		
		Double[] testCalBStar = {0.0, 0.0, 0.0};
		main.setCalBStar(testCalBStar);
		assertTrue(Arrays.deepEquals(main.getCalBStar(), testCalBStar));
		
		Double[] testRealLStar = {0.0, 0.0, 0.0};
		main.setRealLStar(testRealLStar);
		assertTrue(Arrays.deepEquals(main.getRealLStar(), testRealLStar));
		
		Double[] testRealAStar = {0.0, 0.0, 0.0};
		main.setRealAStar(testRealAStar);
		assertTrue(Arrays.deepEquals(main.getRealAStar(), testRealAStar));
		
		Double[] testRealBStar = {0.0, 0.0, 0.0};
		main.setRealBStar(testRealBStar);
		assertTrue(Arrays.deepEquals(main.getRealBStar(), testRealBStar));
		
		Double[] testX = {0.0, 0.0, 0.0};
		main.setX(testX);
		assertTrue(Arrays.deepEquals(main.getX(), testX));
		
		Double[] testY = {0.0, 0.0, 0.0};
		main.setY(testY);
		assertTrue(Arrays.deepEquals(main.getY(), testY));
		
		Double[] testZ = {0.0, 0.0, 0.0};
		main.setZ(testZ);
		assertTrue(Arrays.deepEquals(main.getZ(), testZ));
		
		Double[] testVarX = {0.0, 0.0, 0.0};
		main.setVarX(testVarX);
		assertTrue(Arrays.deepEquals(main.getVarX(), testVarX));
		
		Double[] testVarY = {0.0, 0.0, 0.0};
		main.setVarY(testVarY);
		assertTrue(Arrays.deepEquals(main.getVarY(), testVarY));
		
		Double[] testVarZ = {0.0, 0.0, 0.0};
		main.setVarZ(testVarZ);
		assertTrue(Arrays.deepEquals(main.getVarZ(), testVarZ));
		
		Double [][] testXYZToRGB = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		main.setXYZToRGB(testXYZToRGB);
		assertTrue(Arrays.deepEquals(main.getXYZToRGB(), testXYZToRGB));
		
		Double [][] testSpecToXYZ = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		main.setSpecToXYZ(testSpecToXYZ);
		assertTrue(Arrays.deepEquals(main.getSpecToXYZ(), testSpecToXYZ));
		
		int testNumRuns = 3;
		main.setNumRuns(testNumRuns);
		assertEquals(main.getNumRuns(), testNumRuns);
		
		Double testAddStep = 1.0;
		main.setAddStep(testAddStep);
		assertEquals(main.getAddStep(), testAddStep);
		
		Double testMultStep = 1.0;
		main.setMultStep(testMultStep);
		assertEquals(main.getMultStep(), testMultStep);
		
		Double testExpStep = 1.0;
		main.setExpStep(testExpStep);
		assertEquals(main.getExpStep(), testExpStep);	
		
		main.setCal(calMeth);
		assertEquals(main.getCal(), calMeth);
	}
	
	@Test
	void readCSVTest() throws FileNotFoundException {
		Double[][] expected = {{1.0, 2.0}, {3.0, 4.0}}; 
		File test = new File("Z:\\PMFI Grant\\Grease Monkey\\Colorimeter Calibration\\src\\src\\TestData.csv");
		for(int i = 0; i < expected.length; i++) {
			assertArrayEquals(calMeth.convertDTod1D(main.readCSV(test, 2, 2)[i]), calMeth.convertDTod1D(expected[i]), 0.01);
		}
		Double[] expected1 = {1.0, 2.0};
		File test1 = new File("Z:\\PMFI Grant\\Grease Monkey\\Colorimeter Calibration\\src\\src\\TestData1.csv");
		assertArrayEquals(calMeth.convertDTod1D(main.convertTo1D(main.readCSV(test1, 1, 2))), calMeth.convertDTod1D(expected1), 0.01);
	}
	
	@Test
	void getDataTest() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("1.0");
		expected.add("2.0");
		
		String test = "1.0,2.0";
		for(int i = 0; i < expected.size(); i++) {
			assertEquals(main.getDataFromLine(test).get(i), expected.get(i));
		}
	}
	
	@Test
	void convertTo1DTest() {
		Double[][] test = {{1.0, 2.0, 3.0}};
		Double[] expected = {1.0, 2.0, 3.0};
		
		assertArrayEquals(calMeth.convertDTod1D(main.convertTo1D(test)), calMeth.convertDTod1D(expected),  0.001);
	}
	
	@Test
	void readUserInputTest() throws FileNotFoundException {
		main.setCal(main.readUserInput(main.getCal()));
		
		//Enter when prompted
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData.csv
		//2
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData1.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData1.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData1.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData1.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData1.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\TestData1.csv
		//3
		//0.01
		//0.0001
		//0.01
		
		Double[][] testRawData = {{1.0, 2.0}, {3.0, 4.0}};
		for(int i = 0; i < testRawData.length; i++) {
			assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRawData()[i]), calMeth.convertDTod1D(testRawData[i]), 0.001);
		}
		
		Double[] testSingleArr = {1.0, 2.0};
		
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRealLStar()), calMeth.convertDTod1D(testSingleArr), 0.001);
		
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRealAStar()), calMeth.convertDTod1D(testSingleArr), 0.001);
	
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRealBStar()), calMeth.convertDTod1D(testSingleArr), 0.001);
		
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRealR()), calMeth.convertDTod1D(testSingleArr), 0.001);

		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRealG()), calMeth.convertDTod1D(testSingleArr), 0.001);

		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getRealB()), calMeth.convertDTod1D(testSingleArr), 0.001);
		
		assertEquals(main.getCal().getNumRuns(), 3);
		
		assertEquals(main.getCal().getAddStep(), 0.01, 0.001);
		
		assertEquals(main.getCal().getMultStep(), 0.0001, 0.000001);
		
		assertEquals(main.getCal().getExpStep(), 0.01, 0.001);
	}
	
	@Test
	void initCalTest() throws FileNotFoundException {
		main.setCal(main.initCal(main.getCal()));
		
		//Enter when prompted
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\CalDemo.csv
		//15
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\RealCIEL.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\RealCIEL.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\RealCIEL.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\RealCIEL.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\RealCIEL.csv
		//Z:\PMFI Grant\Grease Monkey\Colorimeter Calibration\src\src\RealCIEL.csv
		//3
		//0.01
		//0.0001
		//0.01
		
		Double[] testAddOff = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		Double[] testMultOff = {1.0/15, 1.0/16, 1.0/17, 1.0/18, 1.0/19, 1.0/20, 1.0/21, 1.0/22, 1.0/23, 1.0/24, 1.0/25, 1.0/26, 1.0/27, 1.0/28};
		Double[] testExpOff = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getAddOffset()), calMeth.convertDTod1D(testAddOff), 0.01);
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getMultOffset()), calMeth.convertDTod1D(testMultOff), 0.01);
		assertArrayEquals(calMeth.convertDTod1D(main.getCal().getExpOffset()), calMeth.convertDTod1D(testExpOff), 0.01);
		
		Double[][] testXYZToRGB = {{3.2404542,-1.5371385,-0.4985314}, {-0.969266,1.8760108,0.041556}, {0.0556434,-0.2040259,1.0572252}};
		
		for(int i = 0; i < testXYZToRGB.length; i++) {
			assertArrayEquals(calMeth.convertDTod1D(main.getCal().getXYZToRGB()[i]), calMeth.convertDTod1D(testXYZToRGB[i]), 0.001);
		}
		
		Double[][] testSpecToXYZ = {{0.08277331,0.3693084,0.3013112,0.0383677,0.03778185,0.3046991,0.7123849,1.106886,0.3496358,0.006809147,1.048485,0.04221473,0.001061495,0.000128739}, 
				{0.01041303,0.06047429,0.1414586,0.3109438,0.6248296,0.9233858,0.9944304,0.8370838,0.1410203,0.002619372,0.5282296,0.01628841,0.000409893,5.01893E-05}, 
				{0.3832822,1.867751,1.76844,0.5549619,0.08852389,0.009753,0.000877926,8.18395E-05,0.0,0.0,9.53013E-06,0.0,0.0,0.0}};
		
		for(int i = 0; i < testSpecToXYZ.length; i++) {
			assertArrayEquals(calMeth.convertDTod1D(main.getCal().getSpecToXYZ()[i]), calMeth.convertDTod1D(testSpecToXYZ[i]), 0.001);
		}
	}
	
	@Test
	void printResultsTest() {
		Double[][] testRawData = {{1.0}};
		Double[][] testAltData = {{1.0}};
		Double[] testAddOffset = {1.0};
		Double[] testMultOffset = {1.0};
		Double[] testExpOffset = {1.0};
		Double[] testDeltaE = {1.0};
		Double[][] testDeltaRGB = {{1.0, 1.0, 1.0}};
		Double testAvgDeltaE = 1.0;
		Double[] testCalR = {1.0};
		Double[] testCalG = {1.0};
		Double[] testCalB = {1.0};
		Double[] testRealR = {1.0};
		Double[] testRealG = {1.0};
		Double[] testRealB = {1.0};
		Double[] testCalLStar = {1.0};
		Double[] testCalAStar = {1.0};
		Double[] testCalBStar = {1.0};
		Double[] testRealLStar = {1.0};
		Double[] testRealAStar = {1.0};
		Double[] testRealBStar = {1.0};
		Double[] testX = {1.0};
		Double[] testY = {1.0};
		Double[] testZ = {1.0};
		Double[] testVarX = {1.0};
		Double[] testVarY = {1.0};
		Double[] testVarZ = {1.0};
		Double[][] testXYZToRGB = {{1.0}};
		Double[][] testSpecToXYZ = {{1.0}};
		int testNumRuns = 1;
		Double testAddStep = 1.0;
		Double testMultStep = 1.0;
		Double testExpStep = 1.0;
		
		main.getCal().setAddOffset(testAddOffset);
		main.getCal().setMultOffset(testMultOffset);
		main.getCal().setExpOffset(testExpOffset);
		main.getCal().setAddStep(testAddStep);
		main.getCal().setMultStep(testMultStep);
		main.getCal().setExpStep(testExpStep);
		main.getCal().setNumRuns(testNumRuns);
		main.getCal().setSpecToXYZ(testSpecToXYZ);
		main.getCal().setXYZToRGB(testXYZToRGB);
		main.getCal().setVarX(testVarX);
		main.getCal().setVarY(testVarY);
		main.getCal().setVarZ(testVarZ);
		main.getCal().setX(testX);
		main.getCal().setY(testY);
		main.getCal().setZ(testZ);
		main.getCal().setRealLStar(testRealLStar);
		main.getCal().setRealAStar(testRealAStar);
		main.getCal().setRealBStar(testRealBStar);
		main.getCal().setCalLStar(testCalLStar);
		main.getCal().setCalAStar(testCalAStar);
		main.getCal().setCalBStar(testCalBStar);
		main.getCal().setRealR(testRealR);
		main.getCal().setRealG(testRealG);
		main.getCal().setRealB(testRealB);
		main.getCal().setCalR(testCalR);
		main.getCal().setCalG(testCalG);
		main.getCal().setCalB(testCalB);
		main.getCal().setDeltaE(testDeltaE);
		main.getCal().setDeltaRGB(testDeltaRGB);
		main.getCal().setAvgDeltaE(testAvgDeltaE);
		main.getCal().setRawData(testRawData);
		main.getCal().setAltData(testAltData);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

		main.printResults(main.getCal());
		String expectedOutput = "Results:\r\n"
				+ "A, B, C, D, E, F, H, I, J, R, S, T, U:\r\n"
				+ "1 \r\n"
				+ "Add:\r\n"
				+ "A, B, C, D, E, F, H, I, J, R, S, T, U:\r\n"
				+ "1 \r\n"
				+ "Mult:\r\n"
				+ "A, B, C, D, E, F, H, I, J, R, S, T, U:\r\n"
				+ "1 \r\n"
				+ "Exp:\r\n"
				+ "A, B, C, D, E, F, H, I, J, R, S, T, U:\r\n"
				+ "1 \r\n"
				+ "XYZ:\r\n"
				+ "X, Y, Z:\r\n"
				+ "	Sample 1: 1, 1, 1\r\n"
				+ "CIELAB:\r\n"
				+ "L, A, B:\r\n"
				+ "	Sample 1: 1, 1, 1\r\n"
				+ "RGB:\r\n"
				+ "R, G, B:\r\n"
				+ "	Sample 1: 1, 1, 1\r\n"
				+ "Delta RGB:\r\n"
				+ "R, G, B:\r\n"
				+ "	Sample 1: 1, 1, 1\r\n"
				+ "Delta E:\r\n"
				+ "	Sample 1: 1\r\n"
				+ "Average Delta E: 1\r\n"
				+ "";
		assertEquals(expectedOutput, outContent.toString());
	}
	
}
