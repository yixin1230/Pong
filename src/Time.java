public class Time {
	//System.nanoTime() return long , current value of the system timer in nanoseconds
	// return
	public static double timeStarted = System.nanoTime();
	public static double getTime()
	{
		return((System.nanoTime() - timeStarted) * 1E-9);//convert nano to seconds
		//小数点后9位
	}
}
