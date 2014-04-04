package myjavautils;

public class Linked<T>
{
	
	public Linked()
	{
		wrappedObject = null;
		prevLink = null;
		nextLink = null;
	}
	
	public Linked(T obj)
	{
		wrappedObject = obj;
		prevLink = null;
		nextLink = null;
	}
	
	private T wrappedObject;
	private Linked<T> prevLink, nextLink;
	
	public final T get()
	{
		return wrappedObject;
	}
	
	public final void set(T newObject)
	{
		wrappedObject = newObject;
	}
	
	public final Linked<T> getPrev()
	{
		return prevLink;
	}
	
	public final Linked<T> getNext()
	{
		return nextLink;
	}
	
	public final static <T> void link(Linked<T> first, Linked<T> second)
	{
		
		if (first != null)
		{
			first.unlinkNext();
			first.nextLink = second;
		}
		
		if (second != null)
		{
			second.unlinkPrev();
			second.prevLink = first;
		}
	}
	
	public final void insertAfter(Linked<T> prev)
	{
		if (prev != null)
		{
			link(this, prev.nextLink);
		}
		
		link(prev, this);
	}
	
	public final void insertBefore(Linked<T> next)
	{
		if (next != null)
		{
			link(next.prevLink, this);
		}
		
		link(this, next);
	}
	
	public final void remove()
	{
		link(prevLink,nextLink);
	}
	
	private void unlinkPrev()
	{
		if (prevLink != null)
		{
			prevLink.nextLink = null;
		}
		
		prevLink = null;
	}
	
	private void unlinkNext()
	{
		if (nextLink != null)
		{
			nextLink.prevLink = null;
		}
		
		nextLink = null;
	}
}
