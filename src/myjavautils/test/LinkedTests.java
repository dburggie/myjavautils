package myjavautils.test;

import myjavautils.*;

public class LinkedTests
{
	
	Linked<Integer> link, link1, link2, link3, link4;
		
	public LinkedTests()
	{
		
		link1 = new Linked<>(1);
		link2 = new Linked<>(2);
		link3 = new Linked<>(3);
		link4 = new Linked<>(4);
		link = null;
		
	}
	
	public static void main(String [] args)
	{
		new LinkedTests().run();
	}
	
	void run()
	{
		link();
		insertAfter();
		insertBefore();
	}
	
	private void unlink()
	{
		link1.remove();
		link2.remove();
		link3.remove();
		link4.remove();
	}
	
	
	private void link()
	{
		unlink();
		
		System.out.println("Testing static link() method:");
		
		Linked.link(link1,link2);
		Linked.link(link2,link3);
		Linked.link(link3,link4);
		
		test("static link()");
		
	}
	
	
	private void insertAfter()
	{
		unlink();
		
		System.out.println("Testing insertAfter() method:");
		
		link4.insertAfter(link3);
		link3.insertAfter(link2);
		link2.insertAfter(link1);
		
		test("insertAfter()");
	}
	
	private void insertBefore()
	{
		unlink();
		
		System.out.println("Testing insertBefore() method:");
		
		link1.insertBefore(link2);
		link2.insertBefore(link3);
		link3.insertBefore(link4);
		
		test("insertBefore");
	
	}
	
	private boolean test(String method)
	{
		
		boolean pass = true;
		
		if (!testForward(method))
		{
			pass = false;
		}
		
		if (!testBackward(method))
		{
			pass = false;
		}
		
		
		if (pass)
		{
			System.out.println("" + method + " passed all tests");
		}
		
		else
		{
			System.out.println("" + method + " method broken");
		}
		
		return pass;
		
	}
	
	private boolean testForward(String method)
	{
		
		boolean pass = true;
		
		link = link1;
		
		int n = 0, i = link.get();
		
		do {
			
			n = link.get();
			if (n != i)
			{
				System.out.println("  " + method + " fail traversing forward");
				pass = false;
			}
			
			i++;
			
			link = link.getNext();
			
		} while (link != null);
		
		return pass;
		
	}
	
	private boolean testBackward(String method)
	{
		
		boolean pass = true;
		
		link = link4;
		
		int n = 0, i = link.get();
		
		do {
			
			n = link.get();
			if (n != i)
			{
				System.out.println("  " + method + " fail traversing backward");
				pass = false;
			}
			
			i--;
			
			link = link.getPrev();
			
		} while (link != null);
		
		return pass;
		
	}
}
