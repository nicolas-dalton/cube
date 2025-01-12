package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class CubeNetImpl_Dalton implements CubeNet
{
	Color top;
	Color front;
	Color right;
	Color back;
	Color left;
	Color bottom;
	public CubeNetImpl_Dalton(Color top, Color bottom, Color left, Color right, Color front, Color back)
	{
		this.top = top;
		this.front = front;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
		this.back = back;
	}
	
	@Override
	public Color getTop() 
	{
		return top;
	}
	@Override
	public Color getFront() 
	{
		return front;
	}
	@Override
	public Color getRight()
	{
		return right;
	}
	@Override
	public Color getBack()
	{
		return back;
	}
	@Override
	public Color getLeft() 
	{
		return left;
	}
	@Override
	public Color getBottom() 
	{
		return bottom;
	}
	private final static String RED_SQUARE = "\uD83D\uDFE5";
	private final static String GREEN_SQUARE = "\uD83D\uDFE9";
	private final static String BLUE_SQUARE = "\uD83D\uDFE6";
	private final static String YELLOW_SQUARE = "\uD83D\uDFE8";
	private final static String ORANGE_SQUARE = "\uD83D\uDFE7";
	private final static String WHITE_SQUARE = "**";
	private final static String BLACK_SQUARE = "\u2B1B";
	private final static String NO_SQUARE = "?";
	
	private static Map<Color, String> colorToSquareMap = new HashMap<Color, String>();
	static
	{
		colorToSquareMap.put(Color.GREEN, GREEN_SQUARE);
		colorToSquareMap.put(Color.RED, RED_SQUARE);
		colorToSquareMap.put(Color.BLUE, BLUE_SQUARE);
		colorToSquareMap.put(Color.YELLOW, YELLOW_SQUARE);
		colorToSquareMap.put(Color.ORANGE, ORANGE_SQUARE);
		colorToSquareMap.put(Color.BLACK, BLACK_SQUARE);
	}
	private static String translateColorToSquare(Color color)
	{
		String squareString = (colorToSquareMap.containsKey(color) ? colorToSquareMap.get(color) : NO_SQUARE);
		return squareString;
	}
	
	public String toString()
	{	
		String translatedTop = translateColorToSquare(getTop());
		String translatedFront = translateColorToSquare(getFront());
		String translatedLeft = translateColorToSquare(getLeft());
		String translatedRight = translateColorToSquare(getRight());
		String translatedBottom = translateColorToSquare(getBottom());
		String translatedBack = translateColorToSquare(getBack());
		
		final String NEW_LINE = "\n";
		String firstRow = 	WHITE_SQUARE 	+ translatedTop 	+ WHITE_SQUARE 		+ NEW_LINE;
		String secondRow = 	translatedLeft 	+ translatedFront 	+ translatedRight 	+ NEW_LINE;
		String thirdRow = 	WHITE_SQUARE 	+ translatedBottom 	+ WHITE_SQUARE 		+ NEW_LINE;
		String fourthRow = 	WHITE_SQUARE 	+ translatedBack 	+ WHITE_SQUARE 		+ NEW_LINE;
		
		return firstRow + secondRow + thirdRow + fourthRow;
	}
	
	public static void main(String[] args)
	{
		CubeNet cubeNet = new CubeNetImpl_Dalton(Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.BLACK);
		System.out.println("cubeNet = \n" + cubeNet);
		
		CubeNet cubeNet2 = new CubeNetImpl_Dalton(Color.RED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
		System.out.println("cubeNet2 = \n" + cubeNet2);
		
		CubeNet cubeNet3 = new CubeNetImpl_Dalton(Color.GREEN, Color.GREEN, Color.GREEN, Color.RED, Color.GREEN, Color.GREEN);
		System.out.println("cubeNet3 = \n" + cubeNet3);
	}
	public boolean equals(Object obj)
	{
		CubeNet cubeNetObject = (CubeNet)(obj);
		boolean result = (getTop() == cubeNetObject.getTop() && getBottom() == cubeNetObject.getBottom() &&
				getFront() == cubeNetObject.getFront() && getBack() == cubeNetObject.getBack() &&
				getRight() == cubeNetObject.getRight() && getLeft() == cubeNetObject.getLeft());
		return result;
	}
	public int hashCode()
	{
		
		return 0;
	}
}
