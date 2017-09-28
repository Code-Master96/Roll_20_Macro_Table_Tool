
import java.io.*;

public class Block
{
	private boolean isNull = true;
	private static boolean eofReached = false;
	private static String attribute;
	private Float lo, hi, value;

	public static boolean getEOF_REACHED()
	{
		return eofReached;
	}

	public Block(FileReader in) throws IOException
	{
		this.read(in);
	}

	public Block(Float l, Float h, Float v)
	{
		lo = l;
		hi = h;
		value = v;
		nullCheck();
	}

	public float getLo()
	{
		return lo;
	}

	public void setLo(float lo)
	{
		nullCheck();
		this.lo = lo;
	}

	public float getHi()
	{
		return hi;
	}

	public void setHi(float hi)
	{
		nullCheck();
		this.hi = hi;
	}

	public float getValue()
	{
		return value;
	}

	public void setValue(float value)
	{
		nullCheck();
		this.value = value;
	}

	public static String getAttribute()
	{
		return attribute;
	}

	public static void setAttribute(String attribute)
	{
		Block.attribute = attribute;
	}

	public void print()
	{
		System.out.println(this.toString());
	}

	public String toString()
	{
		return (isNull)?("isNull"):(attribute + " : [" + lo + ", " + hi + ") : " + value);
	}

	public void toFormula(FileWriter out) throws IOException
	{
		if (!isNull)
		{
			out.write(value.toString() + "*((abs((" + attribute + ") - (" + lo.toString() + ") + 0.001)+ (" + attribute
					+ ")-(" + lo.toString() + ")+0.001)/0.002 - (abs((" + attribute + ")-(" + lo.toString() + "))+("
					+ attribute + ")-(" + lo.toString() + "))/0.002- (abs((" + attribute + ") - (" + hi.toString()
					+ ")+ 0.001)+(" + attribute + ")-(" + hi.toString() + ")+0.001)/0.002 + (abs((" + attribute + ")-("
					+ hi.toString() + "))+(" + attribute + ")-(" + hi.toString() + "))/0.002)");
		}
	}

	public Block read(FileReader in) throws IOException
	{
		if (eofReached)
		{
			isNull = true;
			return null;
		}
		String[] s = new String[3];
		s[0] = "";
		s[1] = "";
		s[2] = "";
		char c = 'a';
		int i = 0;
		do
		{
			try
			{
				c = (char) in.read();
			} catch (IOException e)
			{
				System.out.println("e1");
				return null;
			}
			if (c == '@' || c == '%' || c == '#')
			{
				String a = "";
				while (c != (char)-1 && c != ';')
				{
					a += c;
					c = (char) in.read();
				}
				while (c == ';' || c == '\n')
				{
					c = (char) in.read();
				}
				setAttribute(a.trim());

			}
			if (c == '-')
			{
				c = (char) in.read();
				while (Character.isWhitespace(c) && c != (char)-1)
				{
					c = (char) in.read();
				}
				if (Character.isDigit(c) || c == '.')
				{
					s[i] += "-" + c;
					c = (char) in.read();
				}
			}
			if (Character.isDigit(c) || c == '.')
			{
				s[i] += c;
			}
			if (c == ',')
			{
				i = 1;
			}
			if (c == ')')
			{
				i = 2;
			}
		} while (c != (char)-1 && c != ';');

		if (s[0].length() > 0 && s[1].length() > 0 && s[2].length() > 0)
		{
			lo = Float.parseFloat(s[0]);
			hi = Float.parseFloat(s[1]);
			value = Float.parseFloat(s[2]);
		}
		nullCheck();
		if (c == (char)-1)
		{
			eofReached = true;
		}
		return this;
	}

	public static void main(String[] args) throws IOException
	{

		// handle filenames and paths
		if (args.length < 1)
		{
			System.out.println("not enough arguments");
			return;
		}
		String arg = args[0];
		if (arg.endsWith(".txt"))
		{
			arg = String.copyValueOf(arg.toCharArray(), 0, arg.length() - 4);
		}
		String path = "";
		String inFN = "";
		String outFN = "";
		inFN = path + arg + ".txt";
		outFN = path + arg + "_out.txt";
		FileReader in;
		try
		{
			in = new FileReader(inFN);
		}
		catch (Exception e1)
		{
			String clearScreen = "";
			for(int i = 0; i < 100; i++)
			{
				clearScreen += "\n";
			}
			System.out.print(clearScreen);
			System.out.println(inFN + " cannot be found.");
			System.out.println("");
			System.out.println("Press Enter to Exit... ");
			System.in.read();
			return;
			
		}
		FileWriter out = new FileWriter(outFN);
		out.write("[[round(100*(");
		boolean end = false;
		// Translate
		while (!end && !Block.getEOF_REACHED())
		{
			Block tmp;
			try
			{
				tmp = new Block(in);
				tmp.toFormula(out);
			} catch (IOException e)
			{
				end = true;
			}
		}
		out.write("))/100]]");
		System.out.println("Output saved to \"" + path + outFN + "\"");
		out.close();
		in.close();
	}

	private void nullCheck()
	{
		if (attribute == null || attribute.length() < 1 || lo == null || hi == null || value == null
				|| !Float.isFinite(lo) || !Float.isFinite(hi) || !Float.isFinite(value))
		{
			isNull = true;
		} else
		{
			isNull = false;
		}
	}

}
