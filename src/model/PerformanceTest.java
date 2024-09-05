package model;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PerformanceTest 
{
	public static void main(String[]args)
	{
		Set<Color> fiveColors = new HashSet<>(Arrays.asList(
				Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW));
		CubeSolver_Dalton c = new CubeSolver_Dalton();
		long startTimeMilis = System.currentTimeMillis();
		Set<Cube> fiveColorCube =  c.getDistinctSolidCubes(fiveColors);
		long endTimeMilis = System.currentTimeMillis();
		long duration = (endTimeMilis - startTimeMilis);
		System.out.println("MAIN DURATION FOR 5 COLORS: " + duration);
	}
}
