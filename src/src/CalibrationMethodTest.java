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
			expOffset, deltaE, avgDeltaE, calR, calG, calB, realR, realG, realB,
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
				expOffset, deltaE, avgDeltaE, calR, calG, calR, realR, realG, realB,
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
		Double[] testX = {6.0, 6.0, 6.0};
		Double[] testY = {6.0, 6.0, 6.0};
		Double[] testZ = {6.0, 6.0, 6.0};
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
	
	}
	
	@Test
	public void testCalVarXYZ() {
		Double[] testX = {34.4, 34.4, 34.4};
		Double[] testY = {34.4, 34.4, 34.4};
		Double[] testZ = {32.0, 32.0, 32.0};
		Double[] testVarX = {1.99, 1.99, 1.99};
		Double[] testVarY = {1.99, 1.99, 1.99};
		Double[] testVarZ = {1.99, 1.99, 1.99};
		
		calMeth.setVarX(calMeth.calculateVarX(testX));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarX()), calMeth.convertDTod1D(testVarX), 0.01);
		
		calMeth.setVarY(calMeth.calculateVarY(testY));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarY()), calMeth.convertDTod1D(testVarY), 0.01);
		
		calMeth.setVarZ(calMeth.calculateVarZ(testZ));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarZ()), calMeth.convertDTod1D(testVarZ), 0.01);
		
		Double[] testX1 = {0.03, 0.03, 0.03};
		Double[] testY1 = {0.03, 0.03, 0.03};
		Double[] testZ1 = {0.03, 0.03, 0.03};
		Double[] testVarX1 = {0.054, 0.054, 0.054};
		Double[] testVarY1 = {0.054, 0.054, 0.054};
		Double[] testVarZ1 = {0.054, 0.054, 0.054};
		
		calMeth.setVarX(calMeth.calculateVarX(testX1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarX()), calMeth.convertDTod1D(testVarX1), 0.01);
		
		calMeth.setVarY(calMeth.calculateVarY(testY1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarY()), calMeth.convertDTod1D(testVarY1), 0.01);
		
		calMeth.setVarZ(calMeth.calculateVarZ(testZ1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getVarZ()), calMeth.convertDTod1D(testVarZ1), 0.01);
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
		Double[] testX = {2.15};
		Double[] testY = {2.15};
		Double[] testZ = {2.0};
		Double[] testR = {223.64};
		Double[] testG = {205.52};
		Double[] testB = {203.15};
		Double[][] testXYZToRGB = {{3.24, -1.54, -0.5}, {-.97, 1.88, 0.04}, {0.06, -0.2, 1.06}};
		
		calMeth.setCalR(calMeth.calculateR(testXYZToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalR()), calMeth.convertDTod1D(testR), 0.01);
		
		calMeth.setCalG(calMeth.calculateG(testXYZToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalG()), calMeth.convertDTod1D(testG), 0.01);
		
		calMeth.setCalB(calMeth.calculateB(testXYZToRGB, testX, testY, testZ));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalB()), calMeth.convertDTod1D(testB), 0.01);
		
		Double[] testX1 = {4.3};
		Double[] testY1 = {4.3};
		Double[] testZ1 = {4.0};
		Double[] testR1 = {255.0};
		Double[] testG1 = {255.0};
		Double[] testB1 = {255.0};
		
		calMeth.setCalR(calMeth.calculateR(testXYZToRGB, testX1, testY1, testZ1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalR()), calMeth.convertDTod1D(testR1), 0.01);
		
		calMeth.setCalG(calMeth.calculateG(testXYZToRGB, testX1, testY1, testZ1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalG()), calMeth.convertDTod1D(testG1), 0.01);
		
		calMeth.setCalB(calMeth.calculateB(testXYZToRGB, testX1, testY1, testZ1));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalB()), calMeth.convertDTod1D(testB1), 0.01);
		
		Double[] testX2 = {0.0};
		Double[] testY2 = {0.0};
		Double[] testZ2 = {0.0};
		Double[] testR2 = {0.0};
		Double[] testG2 = {0.0};
		Double[] testB2 = {0.0};
		
		calMeth.setCalR(calMeth.calculateR(testXYZToRGB, testX2, testY2, testZ2));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalR()), calMeth.convertDTod1D(testR2), 0.01);
		
		calMeth.setCalG(calMeth.calculateG(testXYZToRGB, testX2, testY2, testZ2));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalG()), calMeth.convertDTod1D(testG2), 0.01);
		
		calMeth.setCalB(calMeth.calculateB(testXYZToRGB, testX2, testY2, testZ2));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalB()), calMeth.convertDTod1D(testB2), 0.01);
		
		Double[] testX3 = {0.0043};
		Double[] testY3 = {0.0043};
		Double[] testZ3 = {0.004};
		Double[] testR3 = {3.95};
		Double[] testG3 = {3.13};
		Double[] testB3 = {3.03};
		
		calMeth.setCalR(calMeth.calculateR(testXYZToRGB, testX3, testY3, testZ3));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalR()), calMeth.convertDTod1D(testR3), 0.01);
		
		calMeth.setCalG(calMeth.calculateG(testXYZToRGB, testX3, testY3, testZ3));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalG()), calMeth.convertDTod1D(testG3), 0.01);
		
		calMeth.setCalB(calMeth.calculateB(testXYZToRGB, testX3, testY3, testZ3));
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getCalB()), calMeth.convertDTod1D(testB3), 0.01);
	}
	
	@Test
	void testCalDeltaE() {
		Double[] testCalLStar = {100.0, 100.0, 100.0};
		Double[] testCalAStar = {100.0, 100.0, 100.0};
		Double[] testCalBStar = {100.0, 100.0, 100.0};
		Double[] testRealLStar = {90.0, 90.0, 90.0};
		Double[] testRealAStar = {90.0, 90.0, 90.0};
		Double[] testRealBStar = {90.0, 90.0, 90.0};
		Double[] testDeltaE = {17.32, 17.32, 17.32};
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
	void testAdjustAddOffsets() {
		System.out.println("got here 1");		
		Double[] testAddOffset = {0.0, 0.0}; 
		Double[] testAddOffset1 = {0.0, 0.0};
		Double[] testMultOffset = {0.1, 0.1};
		Double[] testExpOffset = {1.0, 1.0};
		Double[][] testRawData = {{10.0, 10.0}};
		Double testAddStep = 0.01;
		Double[][] testSpecToXYZ = {{1.0}, {1.0}, {1.0}};
		System.out.println("got here 2");		

		Double[] testCalLStar = calMeth.calculateLStar(calMeth.calculateVarY(calMeth.calculateY(testRawData, testSpecToXYZ[0])));
		Double[] testCalAStar = calMeth.calculateAStar(calMeth.calculateVarX(calMeth.calculateX(testRawData, testSpecToXYZ[1])), calMeth.calculateVarY(calMeth.calculateY(testRawData, testSpecToXYZ[0])));
		Double[] testCalBStar = calMeth.calculateBStar(calMeth.calculateVarY(calMeth.calculateY(testRawData, testSpecToXYZ[2])), calMeth.calculateVarZ(calMeth.calculateZ(testRawData, testSpecToXYZ[0])));
		System.out.println("got here 3");		

		Double[] testRealLStar = {1.0, 1.0};
		Double[] testRealAStar = {1.0, 1.0};
		Double[] testRealBStar = {1.0, 1.0};
		Double[] testDeltaE = calMeth.calculateDeltaE(testCalLStar, testCalAStar, testCalBStar, testRealLStar, testRealAStar, testRealBStar);
		System.out.println("got here 4");		

		Double testAvgDeltaE = calMeth.averageDeltaE(testDeltaE);
		System.out.println("got here 5");		

		
		calMeth.setAddOffset(calMeth.adjustAddOffsets(testAddOffset, testMultOffset, testExpOffset, testAvgDeltaE, testRawData, testAddStep, testSpecToXYZ, testRealLStar, testRealAStar, testRealBStar));
		System.out.println("got here 6");		
		System.out.print("Add Offset: ");
		System.out.println(calMeth.getAddOffset()[0]);
		System.out.print("Test Add Offset: ");
		System.out.println(testAddOffset1[0]);
		
		assertArrayEquals(calMeth.convertDTod1D(calMeth.getAddOffset()), calMeth.convertDTod1D(testAddOffset1), 0.01);
		System.out.println("got here 7");		

	}

	@Test
	void testAdjustMultOffsets() {
		
	}
	
	@Test
	void testAdjustExpOffsets() {
		
	}
	
}
