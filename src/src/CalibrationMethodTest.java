package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import org.junit.Before;

class CalibrationMethodTest {
	private Double[][] rawData;
	private Double[][] altData;
	private Double[] addOffset;
	private Double[] multOffset;
	private Double[] expOffset;
	private Double[] deltaE;
	private Double avgDeltaE;
	private Double[] maxRGB;
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
	private CalibrationMethod calMeth = new CalibrationMethod(rawData, altData, addOffset, multOffset,
			expOffset, deltaE, avgDeltaE, maxRGB, calR, calG, calB, realR, realG, realB,
			calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
			x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
			addStep, multStep, expStep);
	
	@Before
	public void setUp() {
		rawData = new Double[3][3];
		altData = new Double[3][3];
		addOffset = new Double[3];
		multOffset = new Double[3];
		expOffset = new Double[3];
		deltaE = new Double[3];
		avgDeltaE = 1.0;
		maxRGB = new Double[3];
		calR = new Double[3];
		calG = new Double[3];
		calB = new Double[3];
		realR = new Double[3];
		realG = new Double[3];
		realB = new Double[3];
		calLStar = new Double[3];
		calAStar = new Double[3];
		calBStar = new Double[3];
		realLStar = new Double[3];
		realAStar = new Double[3];
		realBStar = new Double[3];
		x = new Double[3];
		y = new Double[3];
		z = new Double[3];
		varX = new Double[3];
		varY = new Double[3];
		varZ = new Double[3];
		xyzToRGB = new Double[3][3];
		specToXYZ = new Double[3][3];
		numRuns = 3;
		addStep = 1.0;
		multStep = 1.0;
		expStep = 1.0;
		calMeth = new CalibrationMethod(rawData, altData, addOffset, multOffset,
				expOffset, deltaE, avgDeltaE, maxRGB, calR, calG, calR, realR, realG, realB,
				calLStar, calAStar, calBStar, realLStar, realAStar, realBStar,
				x, y, z, varX, varY, varZ, xyzToRGB, specToXYZ, numRuns,
				addStep, multStep, expStep);
	}

	@Test
	public void testGetAndSet() {
		Double [][] testRawData = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		calMeth.setRawData(testRawData);
		assertTrue(Arrays.deepEquals(calMeth.getRawData(), testRawData));
		
		Double [][] testAltData = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		calMeth.setAltData(testAltData);
		assertTrue(Arrays.deepEquals(calMeth.getAltData(), testAltData));
		
		Double[] testAddOffset = {0.0, 0.0, 0.0};
		calMeth.setAddOffset(testAddOffset);
		assertTrue(Arrays.deepEquals(calMeth.getAddOffset(), testAddOffset));
		
		Double[] testMultOffset = {0.0, 0.0, 0.0};
		calMeth.setMultOffset(testMultOffset);
		assertTrue(Arrays.deepEquals(calMeth.getMultOffset(), testMultOffset));
		
		Double[] testExpOffset = {0.0, 0.0, 0.0};
		calMeth.setExpOffset(testExpOffset);
		assertTrue(Arrays.deepEquals(calMeth.getExpOffset(), testExpOffset));
		
		Double[] testDeltaE = {0.0, 0.0, 0.0};
		calMeth.setDeltaE(testDeltaE);
		assertTrue(Arrays.deepEquals(calMeth.getDeltaE(), testDeltaE));
		
		Double testAvgDeltaE = 0.0; 
		calMeth.setAvgDeltaE(testAvgDeltaE);
		assertEquals(calMeth.getAvgDeltaE(), testAvgDeltaE);
		
		Double[] testMaxRGB = {0.0, 0.0, 0.0};
		calMeth.setMaxRGB(testMaxRGB);
		assertTrue(Arrays.deepEquals(calMeth.getMaxRGB(), testMaxRGB));
		
		Double[] testCalR = {0.0, 0.0, 0.0};
		calMeth.setCalR(testCalR);
		assertTrue(Arrays.deepEquals(calMeth.getCalR(), testCalR));
		
		Double[] testCalG = {0.0, 0.0, 0.0};
		calMeth.setCalG(testCalG);
		assertTrue(Arrays.deepEquals(calMeth.getCalG(), testCalG));
		
		Double[] testCalB = {0.0, 0.0, 0.0};
		calMeth.setCalB(testCalB);
		assertTrue(Arrays.deepEquals(calMeth.getCalB(), testCalB));
		
		Double[] testRealR = {0.0, 0.0, 0.0};
		calMeth.setRealR(testRealR);
		assertTrue(Arrays.deepEquals(calMeth.getRealR(), testRealR));
		
		Double[] testRealG = {0.0, 0.0, 0.0};
		calMeth.setRealG(testRealG);
		assertTrue(Arrays.deepEquals(calMeth.getRealG(), testRealG));
		
		Double[] testRealB = {0.0, 0.0, 0.0};
		calMeth.setRealB(testRealB);
		assertTrue(Arrays.deepEquals(calMeth.getRealB(), testRealB));
		
		Double[] testCalLStar = {0.0, 0.0, 0.0};
		calMeth.setCalLStar(testCalLStar);
		assertTrue(Arrays.deepEquals(calMeth.getCalLStar(), testCalLStar));
		
		Double[] testCalAStar = {0.0, 0.0, 0.0};
		calMeth.setCalAStar(testCalAStar);
		assertTrue(Arrays.deepEquals(calMeth.getCalAStar(), testCalAStar));
		
		Double[] testCalBStar = {0.0, 0.0, 0.0};
		calMeth.setCalBStar(testCalBStar);
		assertTrue(Arrays.deepEquals(calMeth.getCalBStar(), testCalBStar));
		
		Double[] testRealLStar = {0.0, 0.0, 0.0};
		calMeth.setRealLStar(testRealLStar);
		assertTrue(Arrays.deepEquals(calMeth.getRealLStar(), testRealLStar));
		
		Double[] testRealAStar = {0.0, 0.0, 0.0};
		calMeth.setRealAStar(testRealAStar);
		assertTrue(Arrays.deepEquals(calMeth.getRealAStar(), testRealAStar));
		
		Double[] testRealBStar = {0.0, 0.0, 0.0};
		calMeth.setRealBStar(testRealBStar);
		assertTrue(Arrays.deepEquals(calMeth.getRealBStar(), testRealBStar));
		
		Double[] testX = {0.0, 0.0, 0.0};
		calMeth.setX(testX);
		assertTrue(Arrays.deepEquals(calMeth.getX(), testX));
		
		Double[] testY = {0.0, 0.0, 0.0};
		calMeth.setY(testY);
		assertTrue(Arrays.deepEquals(calMeth.getY(), testY));
		
		Double[] testZ = {0.0, 0.0, 0.0};
		calMeth.setZ(testZ);
		assertTrue(Arrays.deepEquals(calMeth.getZ(), testZ));
		
		Double[] testVarX = {0.0, 0.0, 0.0};
		calMeth.setVarX(testVarX);
		assertTrue(Arrays.deepEquals(calMeth.getVarX(), testVarX));
		
		Double[] testVarY = {0.0, 0.0, 0.0};
		calMeth.setVarY(testVarY);
		assertTrue(Arrays.deepEquals(calMeth.getVarY(), testVarY));
		
		Double[] testVarZ = {0.0, 0.0, 0.0};
		calMeth.setVarZ(testVarZ);
		assertTrue(Arrays.deepEquals(calMeth.getVarZ(), testVarZ));
		
		Double [][] testXYZToRGB = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		calMeth.setXYZToRGB(testXYZToRGB);
		assertTrue(Arrays.deepEquals(calMeth.getXYZToRGB(), testXYZToRGB));
		
		Double [][] testSpecToXYZ = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		calMeth.setSpecToXYZ(testSpecToXYZ);
		assertTrue(Arrays.deepEquals(calMeth.getSpecToXYZ(), testSpecToXYZ));
		
		int testNumRuns = 3;
		calMeth.setNumRuns(testNumRuns);
		assertEquals(calMeth.getNumRuns(), testNumRuns);
		
		Double testAddStep = 1.0;
		calMeth.setAddStep(testAddStep);
		assertEquals(calMeth.getAddStep(), testAddStep);
		
		Double testMultStep = 1.0;
		calMeth.setMultStep(testMultStep);
		assertEquals(calMeth.getMultStep(), testMultStep);
		
		Double testExpStep = 1.0;
		calMeth.setExpStep(testExpStep);
		assertEquals(calMeth.getExpStep(), testExpStep);		
	}
	
	@Test
	public void testCalXYZ() {
		Double[] testX = {3.0, 3.0, 3.0};
		Double[] testY = {3.0, 3.0, 3.0};
		Double[] testZ = {3.0, 3.0, 3.0};
		Double[][] testRawData = {{1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}};
		Double[][] testSpecToXYZ = {{1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}};
		
		calMeth.setRawData(testRawData);
		calMeth.setSpecToXYZ(testSpecToXYZ);
		
		calMeth.setX(calMeth.calculateX(calMeth.getRawData(), calMeth.getSpecToXYZ()[0]));
		assertTrue(Arrays.deepEquals(calMeth.getX(), testX));
		
		calMeth.setY(calMeth.calculateY(calMeth.getRawData(), calMeth.getSpecToXYZ()[1]));
		assertTrue(Arrays.deepEquals(calMeth.getY(), testY));
		
		calMeth.setZ(calMeth.calculateZ(calMeth.getRawData(), calMeth.getSpecToXYZ()[2]));
		assertTrue(Arrays.deepEquals(calMeth.getZ(), testZ));
		
		Double[] testX1 = {49.02, 11.02, 3.93};
		Double[] testY1 = {52.07, 6.81, 6.10};
		Double[] testZ1 = {36.14, 2.51, 10.61};
		Double[][] testRawData1 = {{2.00, 6.47, 10.00, 8.00, 12.00, 9.87, 11.33, 15.00, 6.67, 2.00, 12.00, 2.00, 1.00, 1.00}, 
				{0.00, 1.00, 0.00, 1.00, 1.00, 0.00, 0.20, 2.00, 5.20, 3.00, 6.00, 2.00, 2.00, 1.00}, 
				{0.00, 1.80, 3.00, 3.00, 3.00, 1.00, 1.00, 1.00, 0.00, 1.00, 0.00, 0.00, 1.00, 0.00}};
		Double[][] testSpecToXYZ1 = {{0.08277331, 0.3693084, 0.3013112, 0.0383677, 0.03778185, 0.3046991, 0.7123849, 1.106886, 0.3496358, 0.006809147, 1.048485, 0.04221473, 0.001061495, 0.0001287394}, 
				{0.01041303, 0.06047429, 0.1414586, 0.3109438, 0.6248296, 0.9233858, 0.9944304, 0.8370838, 0.1410203, 0.002619372, 0.5282296, 0.01628841, 0.0004098928, 0.00005018934}, 
				{0.3832822, 1.867751, 1.76844, 0.5549619, 0.08852389, 0.009753, 0.0008779264, 0.00008183954, 0.0, 0.0, 0.00000953013, 0.0, 0.0, 0.0}};
		
		calMeth.setRawData(testRawData1);
		calMeth.setSpecToXYZ(testSpecToXYZ1);
		
		calMeth.setX(calMeth.calculateX(calMeth.getRawData(), calMeth.getSpecToXYZ()[0]));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getX()), calMeth.convertDTod1D(testX1), 0.01);
		
		calMeth.setY(calMeth.calculateY(calMeth.getRawData(), calMeth.getSpecToXYZ()[1]));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getY()), calMeth.convertDTod1D(testY1), 0.01);
		
		calMeth.setZ(calMeth.calculateZ(calMeth.getRawData(), calMeth.getSpecToXYZ()[2]));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getZ()), calMeth.convertDTod1D(testZ1), 0.01);
	
	}
	
	@Test
	public void testCalVarXYZ() {
		Double[] testX = {34.4, 0.03, 49.02, 11.02, 3.93};
		Double[] testY = {34.4, 0.03, 52.07, 6.81, 6.10};
		Double[] testZ = {32.0, 0.03, 36.14, 2.51, 10.61};
		Double[] testVarX = {1.999, 0.192, 2.251, 1.368, 0.970};
		Double[] testVarY = {1.999, 0.192, 2.296, 1.166, 1.124};
		Double[] testVarZ = {1.999, 0.196, 2.083, 0.856, 1.384};
		
		calMeth.setVarX(calMeth.calculateVarX(testX));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarX()), calMeth.convertDTod1D(testVarX), 0.001);
		
		calMeth.setVarY(calMeth.calculateVarY(testY));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarY()), calMeth.convertDTod1D(testVarY), 0.001);
		
		calMeth.setVarZ(calMeth.calculateVarZ(testZ));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarZ()), calMeth.convertDTod1D(testVarZ), 0.001);
		
		
	}
	
	@Test
	void testCalLAB() {
		Double[] testVarX = {1.2, 1.2, 1.2};
		Double[] testVarY = {1.0, 1.0, 1.0};
		Double[] testVarZ = {0.5, 0.5, 0.5};
		Double[] testLStar = {100.0, 100.0, 100.0};
		Double[] testAStar = {100.0, 100.0, 100.0};
		Double[] testBStar = {100.0, 100.0, 100.0};
		
		calMeth.setCalLStar(calMeth.calculateLStar(testVarY));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalLStar()), calMeth.convertDTod1D(testLStar), 0.01);
		
		calMeth.setCalAStar(calMeth.calculateAStar(testVarX, testVarY));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalAStar()), calMeth.convertDTod1D(testAStar), 0.01);
		
		calMeth.setCalBStar(calMeth.calculateBStar(testVarY, testVarZ));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalBStar()), calMeth.convertDTod1D(testBStar), 0.01);
	}
	
	@Test
	void testCalRGB() {
		Double[] testX = {1.0, 0.01};
		Double[] testY = {1.0, 0.01};
		Double[] testZ = {1.0, 0.01};
		Double[] testR = {0.6574, 0.0349};
		Double[] testG = {0.6118, 0.0286};
		Double[] testB = {0.6224, 0.0300};
		Double[][] xyzToRGB = {{3.24, -1.54, -0.5}, {-0.97, 1.88, 0.04}, {0.06, -0.2, 1.06}};
		
		calMeth.setCalR(calMeth.calculateR(xyzToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(testR), calMeth.convertDTod1D(calMeth.getCalR()), 0.0001);
		
		calMeth.setCalG(calMeth.calculateG(xyzToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(testG), calMeth.convertDTod1D(calMeth.getCalG()), 0.0001);
		
		calMeth.setCalB(calMeth.calculateB(xyzToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(testB), calMeth.convertDTod1D(calMeth.getCalB()), 0.0001);
	}
	
	@Test
	void testCalMaxRGB() {
		Double[] testMaxRGB = {0.0};
		Double[] testR = {1.0};
		Double[] testG = {2.0};
		Double[] testB = {3.0};
		
		calMeth.setMaxRGB(calMeth.calculateMaxRGB(testMaxRGB, testR, testR, testR));
		assertArrayEquals(calMeth.convertDTod1D(testR), calMeth.convertDTod1D(calMeth.getMaxRGB()), 0.01);
		
		calMeth.setMaxRGB(calMeth.calculateMaxRGB(testMaxRGB, testR, testG, testG));
		assertArrayEquals(calMeth.convertDTod1D(testG), calMeth.convertDTod1D(calMeth.getMaxRGB()), 0.01);
		
		calMeth.setMaxRGB(calMeth.calculateMaxRGB(testMaxRGB, testR, testG, testB));
		assertArrayEquals(calMeth.convertDTod1D(testB), calMeth.convertDTod1D(calMeth.getMaxRGB()), 0.01);
		
		calMeth.setMaxRGB(calMeth.calculateMaxRGB(testMaxRGB, testB, testR, testG));
		assertArrayEquals(calMeth.convertDTod1D(testB), calMeth.convertDTod1D(calMeth.getMaxRGB()), 0.01);
		
		calMeth.setMaxRGB(calMeth.calculateMaxRGB(testMaxRGB, testB, testG, testR));
		assertArrayEquals(calMeth.convertDTod1D(testB), calMeth.convertDTod1D(calMeth.getMaxRGB()), 0.01);
	}
	
	@Test
	void testScaleRGB() {
		Double[] testR = {0.6574, 0.0, 1.0};
		Double[] testG = {0.6118, 0.0, 1.0};
		Double[] testB = {0.6224, 0.0, 1.0};
		Double[] expectedR = {167.62, 0.0, 127.5};
		Double[] expectedG = {156.00, 0.0, 127.5};
		Double[] expectedB = {158.71, 0.0, 127.5};
		Double[] testMaxRGB = {0.0, 0.0, 2.0};
		
		calMeth.setCalR(calMeth.scaleRGB(testMaxRGB, testR));
		assertArrayEquals(calMeth.convertDTod1D(expectedR), calMeth.convertDTod1D(calMeth.getCalR()), 0.1);
		
		calMeth.setCalG(calMeth.scaleRGB(testMaxRGB, testG));
		assertArrayEquals(calMeth.convertDTod1D(expectedG), calMeth.convertDTod1D(calMeth.getCalG()), 0.1);
		
		calMeth.setCalB(calMeth.scaleRGB(testMaxRGB, testB));
		assertArrayEquals(calMeth.convertDTod1D(expectedB), calMeth.convertDTod1D(calMeth.getCalB()), 0.1);
	}

	@Test
	void testFullCalcRGB() {
		Double[] testX = {49.0, 0.0, 26.8};
		Double[] testY = {52.1, 0.0, 26.6};
		Double[] testZ = {36.1, 0.0, 10.5};
		Double[] testR = {2.7223, 0.0, 2.3683};
		Double[] testG = {2.5982, 0.0, 1.9785};
		Double[] testB = {2.2204, 0.0, 1.3355};
		Double[][] xyzToRGB = {{3.24, -1.54, -0.5}, {-0.97, 1.88, 0.04}, {0.06, -0.2, 1.06}};
		Double[] testMaxRGB = {0.0, 0.0, 0.0};
		Double[] expectedR = {255.0, 0.0, 255.0};
		Double[] expectedG = {243.38, 0.0, 213.03};
		Double[] expectedB = {207.99, 0.0, 143.8};
		
		calMeth.setCalR(calMeth.calculateR(xyzToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(testR), calMeth.convertDTod1D(calMeth.getCalR()), 0.0001);
		
		calMeth.setCalG(calMeth.calculateG(xyzToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(testG), calMeth.convertDTod1D(calMeth.getCalG()), 0.0001);
		
		calMeth.setCalB(calMeth.calculateB(xyzToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(testB), calMeth.convertDTod1D(calMeth.getCalB()), 0.0001);
		
		calMeth.setMaxRGB(calMeth.calculateMaxRGB(testMaxRGB, testR, testG, testB));
		assertArrayEquals(calMeth.convertDTod1D(testR), calMeth.convertDTod1D(calMeth.getMaxRGB()), 0.0001);
		
		calMeth.setCalR(calMeth.scaleRGB(calMeth.getMaxRGB(), testR));
		assertArrayEquals(calMeth.convertDTod1D(expectedR), calMeth.convertDTod1D(calMeth.getCalR()), 0.01);
		
		calMeth.setCalG(calMeth.scaleRGB(calMeth.getMaxRGB(), testG));
		assertArrayEquals(calMeth.convertDTod1D(expectedG), calMeth.convertDTod1D(calMeth.getCalG()), 0.01);
		
		calMeth.setCalB(calMeth.scaleRGB(calMeth.getMaxRGB(), testB));
		assertArrayEquals(calMeth.convertDTod1D(expectedB), calMeth.convertDTod1D(calMeth.getCalB()), 0.01);
	}
	
	@Test
	void testCalDeltaE() {
		Double[] testCalLStar = {100.0, 248.2, 0.0};
		Double[] testCalAStar = {100.0, -22.4, 0.0};
		Double[] testCalBStar = {100.0, 41.9, 0.0};
		Double[] testRealLStar = {90.0, 61.0, 2.0};
		Double[] testRealAStar = {90.0, 1.0, 0.0};
		Double[] testRealBStar = {90.0, 9.0, 0.0};
		Double[] testDeltaE = {17.32, 191.5, 2.0};
		
		calMeth.setDeltaE(calMeth.calculateDeltaE(testCalLStar, testCalAStar, testCalBStar, testRealLStar, testRealAStar, testRealBStar));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getDeltaE()), calMeth.convertDTod1D(testDeltaE), 0.01);
	}
	
	@Test
	void testAvgDeltaE() {
		Double[] testDeltaE = {10.0, 20.0, 30.0};
		Double testAvgDeltaE = 20.0;
		calMeth.setAvgDeltaE(calMeth.averageDeltaE(testDeltaE));
		assertEquals((double) calMeth.getAvgDeltaE(), (double) testAvgDeltaE, 0.01);
	}
	
	@Test
	void testApplyOffsets() {
		Double [][] testRawData = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		Double [][] testAltData = {{16.0, 16.0, 16.0}, {16.0, 16.0, 16.0}, {16.0, 16.0, 16.0}};
		Double[] testAddOffset = {2.0, 2.0, 2.0};
		Double[] testMultOffset = {2.0, 2.0, 2.0};
		Double[] testExpOffset = {2.0, 2.0, 2.0};
		
		calMeth.setAltData(calMeth.applyOffsets(testRawData, testAddOffset, testMultOffset, testExpOffset));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAltData()[0]), calMeth.convertDTod1D(testAltData[0]), 0.01);
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAltData()[1]), calMeth.convertDTod1D(testAltData[1]), 0.01);
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAltData()[2]), calMeth.convertDTod1D(testAltData[2]), 0.01);
		
		Double [][] testAltData1 = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
		Double[] testAddOffset1 = {0.0, 0.0, 0.0};
		Double[] testMultOffset1 = {0.0, 0.0, 0.0};
		Double[] testExpOffset1 = {0.0, 0.0, 0.0};
		
		calMeth.setAltData(calMeth.applyOffsets(testRawData, testAddOffset1, testMultOffset1, testExpOffset1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAltData()[0]), calMeth.convertDTod1D(testAltData1[0]), 0.01);
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAltData()[1]), calMeth.convertDTod1D(testAltData1[1]), 0.01);
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAltData()[2]), calMeth.convertDTod1D(testAltData1[2]), 0.01);

	}
	
	@Test
	void testAdjustOffsets() {
		Double[] testAddOffset = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
		Double[] testMultOffset = {0.5000, 0.1429, 0.0962, 0.1111, 0.0769, 0.0909, 0.0769, 0.0549, 0.1250, 0.3333, 0.0714, 0.5000, 0.5000, 1.0000};
		Double[] testExpOffset = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		
		calMeth.setAddOffset(testAddOffset);
		calMeth.setMultOffset(testMultOffset);
		calMeth.setExpOffset(testExpOffset);
		
		Double[] expectedAddOffset = {0.00, -0.63, -10.00, -8.00, -0.56, -0.58, -7.15, -5.93, 0.00, 0.00, -1.47, -2.00, -1.00, -1.00};
		Double[] expectedMultOffset = {0.5000, 0.1423, 0.0282, 0.0002, 0.0731, 0.0889, 0.0648, 0.0484, 0.1250, 0.3333, 0.0693, 0.5713, 41.9632, 2164.3134};
		Double[] expectedExpOffset = {1.00, 2.46, 1.00, 1.00, 1.17, 1.22, 9.45, 1.41, 0.61, 0.02, 0.79, 1.00, 1.00, 1.01};
		
		Double[][] testRawData = {{2.00, 6.47, 10.00, 8.00, 12.00, 9.87, 11.33, 15.00, 6.67, 2.00, 12.00, 2.00, 1.00, 1.00}};
		
		calMeth.setRawData(testRawData);
		
		Double testAddStep = 0.01;
		Double testMultStep = 0.0001;
		Double testExpStep = 0.01;
		
		calMeth.setAddStep(testAddStep);
		calMeth.setMultStep(testMultStep);
		calMeth.setExpStep(testExpStep);
		
		Double[][] testSpecToXYZ = {{0.08277331, 0.3693084, 0.3013112, 0.0383677, 0.03778185, 0.3046991, 0.7123849, 1.106886, 0.3496358, 0.006809147, 1.048485, 0.04221473, 0.001061495, 0.0001287394}, 
				{0.01041303, 0.06047429, 0.1414586, 0.3109438, 0.6248296, 0.9233858, 0.9944304, 0.8370838, 0.1410203, 0.002619372, 0.5282296, 0.01628841, 0.0004098928, 0.00005018934}, 
				{0.3832822, 1.867751, 1.76844, 0.5549619, 0.08852389, 0.009753, 0.0008779264, 0.00008183954, 0.0, 0.0, 0.00000953013, 0.0, 0.0, 0.0}};
		
		calMeth.setSpecToXYZ(testSpecToXYZ);
		
		Double[] testX = calMeth.calculateX(testRawData, testSpecToXYZ[0]);
		Double[] testY = calMeth.calculateX(testRawData, testSpecToXYZ[1]);
		Double[] testZ = calMeth.calculateX(testRawData, testSpecToXYZ[2]);
		
		calMeth.setX(testX);
		calMeth.setY(testY);
		calMeth.setZ(testZ);
		
		Double[] testVarX = calMeth.calculateVarX(testX);
		Double[] testVarY = calMeth.calculateVarY(testY);
		Double[] testVarZ = calMeth.calculateVarZ(testZ);
		
		calMeth.setVarX(testVarX);
		calMeth.setVarY(testVarY);
		calMeth.setVarZ(testVarZ);
		
		Double[] testCalLStar = calMeth.calculateLStar(calMeth.getVarY());
		Double[] testCalAStar = calMeth.calculateAStar(calMeth.getVarX(), calMeth.getVarY());
		Double[] testCalBStar = calMeth.calculateBStar(calMeth.getVarY(), calMeth.getVarZ());
		
		calMeth.setCalLStar(testCalLStar);
		calMeth.setCalAStar(testCalAStar);
		calMeth.setCalBStar(testCalBStar);
		
		Double[] testRealLStar = {61.0};
		Double[] testRealAStar = {1.0};
		Double[] testRealBStar = {9.0};
		
		calMeth.setRealLStar(testRealLStar);
		calMeth.setRealAStar(testRealAStar);
		calMeth.setRealBStar(testRealBStar);
		
		Double[] testDeltaE = calMeth.calculateDeltaE(testCalLStar, testCalAStar, testCalBStar, testRealLStar, testRealAStar, testRealBStar);
		Double testAvgDeltaE = calMeth.averageDeltaE(testDeltaE);
		
		calMeth.setDeltaE(testDeltaE);
		calMeth.setAvgDeltaE(testAvgDeltaE);

		calMeth.setMultOffset(calMeth.adjustMultOffsets(testAddOffset, testMultOffset, testExpOffset, testAvgDeltaE, testRawData, testMultStep, testSpecToXYZ, testRealLStar, testRealAStar, testRealBStar));
		calMeth.setAltData(calMeth.applyOffsets(testRawData, testAddOffset, calMeth.getMultOffset(), testExpOffset));
		calMeth.setX(calMeth.calculateX(calMeth.getAltData(), calMeth.getSpecToXYZ()[0]));
		calMeth.setY(calMeth.calculateY(calMeth.getAltData(), calMeth.getSpecToXYZ()[1]));
		calMeth.setZ(calMeth.calculateZ(calMeth.getAltData(), calMeth.getSpecToXYZ()[2]));
		calMeth.setVarX(calMeth.getX());
		calMeth.setVarY(calMeth.getY());
		calMeth.setVarZ(calMeth.getZ());
		calMeth.setCalLStar(calMeth.calculateLStar(calMeth.getVarY()));
		calMeth.setCalAStar(calMeth.calculateAStar(calMeth.getVarX(), calMeth.getVarY()));
		calMeth.setCalBStar(calMeth.calculateBStar(calMeth.getVarY(), calMeth.getVarZ()));
		calMeth.averageDeltaE(calMeth.calculateDeltaE(calMeth.getCalLStar(), calMeth.getCalAStar(), calMeth.getCalBStar(), testRealLStar, testRealAStar, testRealBStar));
		
		for(int i = 0; i < testMultOffset.length; i++) {
			System.out.print(calMeth.getMultOffset()[i] + ", ");
		}
		System.out.println();
		
		assertArrayEquals(calMeth.convertDTod1D(expectedMultOffset), calMeth.convertDTod1D(calMeth.getMultOffset()), 0.0001);
		
		calMeth.setAddOffset(calMeth.adjustAddOffsets(testAddOffset, calMeth.getMultOffset(), testExpOffset, calMeth.getAvgDeltaE(), testRawData, testAddStep, testSpecToXYZ, testRealLStar, testRealAStar, testRealBStar));
		calMeth.setAltData(calMeth.applyOffsets(testRawData, calMeth.getAddOffset(), calMeth.getMultOffset(), testExpOffset));
		calMeth.setX(calMeth.calculateX(calMeth.getAltData(), calMeth.getSpecToXYZ()[0]));
		calMeth.setY(calMeth.calculateY(calMeth.getAltData(), calMeth.getSpecToXYZ()[1]));
		calMeth.setZ(calMeth.calculateZ(calMeth.getAltData(), calMeth.getSpecToXYZ()[2]));
		calMeth.setVarX(calMeth.getX());
		calMeth.setVarY(calMeth.getY());
		calMeth.setVarZ(calMeth.getZ());
		calMeth.setCalLStar(calMeth.calculateLStar(calMeth.getVarY()));
		calMeth.setCalAStar(calMeth.calculateAStar(calMeth.getVarX(), calMeth.getVarY()));
		calMeth.setCalBStar(calMeth.calculateBStar(calMeth.getVarY(), calMeth.getVarZ()));
		calMeth.averageDeltaE(calMeth.calculateDeltaE(calMeth.getCalLStar(), calMeth.getCalAStar(), calMeth.getCalBStar(), testRealLStar, testRealAStar, testRealBStar));
		
		for(int i = 0; i < testAddOffset.length; i++) {
			System.out.print(calMeth.getAddOffset()[i] + ", ");
		}
		System.out.println();
		assertArrayEquals(calMeth.convertDTod1D(expectedAddOffset), calMeth.convertDTod1D(calMeth.getAddOffset()), 0.01);
		
		calMeth.setExpOffset(calMeth.adjustExpOffsets(calMeth.getAddOffset(), calMeth.getMultOffset(), testExpOffset, calMeth.getAvgDeltaE(), testRawData, testExpStep, testSpecToXYZ, testRealLStar, testRealAStar, testRealBStar));
		calMeth.setAltData(calMeth.applyOffsets(testRawData, calMeth.getAddOffset(), calMeth.getMultOffset(), calMeth.getExpOffset()));
		calMeth.setX(calMeth.calculateX(calMeth.getAltData(), calMeth.getSpecToXYZ()[0]));
		calMeth.setY(calMeth.calculateY(calMeth.getAltData(), calMeth.getSpecToXYZ()[1]));
		calMeth.setZ(calMeth.calculateZ(calMeth.getAltData(), calMeth.getSpecToXYZ()[2]));
		calMeth.setVarX(calMeth.getX());
		calMeth.setVarY(calMeth.getY());
		calMeth.setVarZ(calMeth.getZ());
		calMeth.setCalLStar(calMeth.calculateLStar(calMeth.getVarY()));
		calMeth.setCalAStar(calMeth.calculateAStar(calMeth.getVarX(), calMeth.getVarY()));
		calMeth.setCalBStar(calMeth.calculateBStar(calMeth.getVarY(), calMeth.getVarZ()));
		calMeth.averageDeltaE(calMeth.calculateDeltaE(calMeth.getCalLStar(), calMeth.getCalAStar(), calMeth.getCalBStar(), testRealLStar, testRealAStar, testRealBStar));
		
		for(int i = 0; i < testExpOffset.length; i++) {
			System.out.print(calMeth.getExpOffset()[i] + ", ");
		}
		System.out.println();
		
		assertArrayEquals(calMeth.convertDTod1D(expectedExpOffset), calMeth.convertDTod1D(calMeth.getExpOffset()), 0.01);
	}

	@Test
	void testConvertMethods() {
		Double[][] twoD = {{1.0, 2.0}, {3.0, 4.0}};
		Double[] oneD = {1.0, 2.0};
		double[][] expectedTwoD = {{1.0, 2.0}, {3.0, 4.0}};
		double[] expectedOneD = {1.0, 2.0};
		
		for(int i = 0; i < twoD.length; i++) {
			assertArrayEquals(calMeth.convertDTod2D(twoD)[i], expectedTwoD[i], 0.01);
		}
		
		assertArrayEquals(calMeth.convertDTod1D(oneD), expectedOneD, 0.01);
	}
}
