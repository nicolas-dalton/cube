package test;

import static org.junit.Assert.*;


import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.Cube;
import model.CubeImpl_Dalton;
import model.CubeNet;
import model.CubeNetImpl_Dalton;
import model.CubeSolver_Dalton;

public class CubeTest_Dalton 
{

	@Test
	public void testEqualsForCube() 
	{
		Cube cubeA = new CubeImpl_Dalton(Color.RED, Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.BLUE);
		Cube cubeB = new CubeImpl_Dalton(Color.RED, Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.BLUE);
		
		boolean expectedRV = true;
		boolean actualRV =  cubeA.equals(cubeB);
		assertEquals(actualRV, expectedRV);
		
		Cube cubeC = new CubeImpl_Dalton(Color.YELLOW, Color.RED, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE);
		Cube cubeD = new CubeImpl_Dalton(Color.BLUE, Color.BLUE, Color.YELLOW, Color.RED, Color.BLUE, Color.BLUE);
		
		expectedRV = true;
		actualRV =  cubeC.equals(cubeD);
		assertEquals(actualRV, expectedRV);
		actualRV =  cubeD.equals(cubeC);
		assertEquals(actualRV, expectedRV);
		
		expectedRV = false;
		actualRV =  cubeC.equals(cubeA);
		assertEquals(actualRV, expectedRV);
		
		Cube cubeE = new CubeImpl_Dalton(Color.BLUE, Color.BLUE, Color.YELLOW, Color.RED, Color.BLUE, Color.BLUE);
		
	}
	@Test
	public void testEqualsForCube__YELLOW_RED_BLUE_BLUE_GREEN_BLUE__BLUE_GREEN_BLUE_BLUE_YELLOW_RED()
	{
		Cube cubeA = new CubeImpl_Dalton(Color.YELLOW, Color.RED, Color.BLUE, Color.BLUE, Color.GREEN, Color.BLUE);
		Cube cubeB = new CubeImpl_Dalton(Color.GREEN, Color.BLUE, Color.BLUE, Color.BLUE, Color.YELLOW, Color.RED);
		
		boolean expectedRV = true;
		boolean actualRV =  cubeA.equals(cubeB);
		assertEquals(actualRV, expectedRV);
		
		actualRV =  cubeB.equals(cubeA);
		assertEquals(actualRV, expectedRV);
	}
	
	@Test
	public void testEqualsForCube__RED_RED_BLUE_BLUE_RED_RED__RED_BLUE_BLUE_RED_RED_RED()
	{
		Cube cubeA = new CubeImpl_Dalton(Color.RED, Color.RED, Color.BLUE, Color.BLUE, Color.RED, Color.RED);
		Cube cubeB = new CubeImpl_Dalton(Color.RED, Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.RED);
		
		boolean expectedRV = false;
		boolean actualRV =  cubeA.equals(cubeB);
		assertEquals(actualRV, expectedRV);
		
		actualRV =  cubeB.equals(cubeA);
		assertEquals(actualRV, expectedRV);
	}
	@Test
	public void testEqualsForCube__RED_GREEN_BLACK_BLUE_YELLOW_ORANGE__ORANGE_YELLOW_BLACK_BLUE_RED_GREEN()
	{
		Cube cubeA = new CubeImpl_Dalton(Color.RED, Color.GREEN, Color.BLACK, Color.BLUE, Color.YELLOW, Color.ORANGE);
		Cube cubeB = new CubeImpl_Dalton(Color.YELLOW, Color.ORANGE, Color.BLACK, Color.BLUE, Color.RED, Color.GREEN);
		
		boolean expectedRV = true;
		boolean actualRV =  cubeA.equals(cubeB);
		assertEquals(actualRV, expectedRV);
		
		actualRV =  cubeB.equals(cubeA);
		assertEquals(actualRV, expectedRV);
	}
	
	@Test
	public void testEqualsForCubeNet() 
	{
		CubeNet cubeA = new CubeNetImpl_Dalton(Color.RED, Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.BLUE);
		CubeNet cubeB = new CubeNetImpl_Dalton(Color.RED, Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.BLUE);
		
		boolean expectedRV = true;
		boolean actualRV =  cubeA.equals(cubeB);
		assertEquals(actualRV, expectedRV);
	}
	@Test
	public void testDistinctCubes__RED()
	{
		
		Cube cubeA = new CubeImpl_Dalton(Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED);
		Set <Cube> expectedSet = new HashSet<>();
		expectedSet.add(cubeA);
		
		Set <Color> colors = new HashSet<>(Arrays.asList(Color.RED));
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		Set <Cube> actualSet = c.getDistinctSolidCubes(colors);
		
		assertEquals(actualSet, expectedSet);
	}
	
	@Test
	public void testDistinctCubes__RED_BLUE()
	{
		
		
		int expectedSetSize = 64;
		
		Set <Color> colors = new HashSet<>(Arrays.asList(Color.RED,Color.BLUE));
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		Set <Cube> actualSet = c.getDistinctSolidCubes(colors);
		
		int actualSetSize = actualSet.size();
		
		assert actualSetSize < expectedSetSize;
		//Red Cube
		Cube cube1 = new CubeImpl_Dalton(Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED);
		//1 Blue and 5 Reds
		Cube cube2 = new CubeImpl_Dalton(Color.RED, Color.BLUE, Color.RED, Color.RED, Color.RED, Color.RED);
		//2 Blues and 4 Reds
		Cube cube3 = new CubeImpl_Dalton(Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.RED, Color.RED);
		Cube cube4 = new CubeImpl_Dalton(Color.BLUE, Color.RED, Color.RED, Color.RED, Color.RED, Color.BLUE);
		//3 Blues and 3 Reds
		Cube cube5 = new CubeImpl_Dalton(Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.RED, Color.BLUE);
		//4 Blues and 2 Reds
		Cube cube6 = new CubeImpl_Dalton(Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.BLUE);
		Cube cube7 = new CubeImpl_Dalton(Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.BLUE, Color.BLUE);
		// 5 BLues and 1 Red
		Cube cube8 = new CubeImpl_Dalton(Color.RED, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE);
		// Blue Cube
		Cube cube9 = new CubeImpl_Dalton(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE);
		
		Cube cube10 = new CubeImpl_Dalton(Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.BLUE);
		
		Set <Cube> expectedSet = new HashSet<>(Arrays.asList(cube1, cube2, cube3, cube4,
				cube5, cube6, cube7, cube8, cube9, cube10));
		assertEquals(actualSet, expectedSet);
	}
	@Test
	public void testDistinctCubes__RED_BLUE_GREEN()
	{
		int expectedSetSize = 729;
		
		Set <Color> colors = new HashSet<>(Arrays.asList(Color.RED,Color.BLUE, Color.GREEN));
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		Set <Cube> actualSet = c.getDistinctSolidCubes(colors);
		
		int actualSetSize = actualSet.size();
		
		assert actualSetSize < expectedSetSize;

	}
	@Test
	public void testDistinctCubes__emptySet()
	{
		Set <Color> colors = new HashSet<>();
		int expectedSetSize = 0;
		
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		Set <Cube> actualSet = c.getDistinctSolidCubes(colors);
		int actualSetSize = actualSet.size();
		
		assert actualSetSize == expectedSetSize;
	}
	@Test(expected = AssertionError.class)
	public void testDistinctCubes_null()
	{
		Set <Color> colors = null;
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		Set <Cube> actualSet = c.getDistinctSolidCubes(colors);
	}
	@Test(expected = AssertionError.class)
	public void testDistinctCubes_RED_BLUE_GREEN_BLUE_BLUE_null()
	{
		Set <Color> colors = new HashSet<>(Arrays.asList(Color.RED,Color.BLUE,Color.GREEN, Color.BLUE, Color.BLUE, null));
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		Set <Cube> actualSet = c.getDistinctSolidCubes(colors);
	}
}
