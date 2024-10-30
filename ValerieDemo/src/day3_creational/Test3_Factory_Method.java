package day3_creational;

//Factory Method: when we have an interface to create object
//what object we will get eventually, depends on the subclass of this interface
public class Test3_Factory_Method {

	public static void main(String[] args) {
		ReaderFactory factory1 = new JPEGFactory();
		Reader reader1 = factory1.getReader();
		reader1.read();
		
		ReaderFactory factory2 = new PNGFactory();
		Reader reader2 = factory2.getReader();
		reader2.read();
	}

}
//interface--Reader--read():
//JPEGReader -> "reading a jpeg picture"
//PNGReader -> "reading a png picture"
//GIFReader -> "reading a gif picture"
interface Reader{
	void read();
}
class JPEGReader implements Reader{
	public void read() {
		System.out.println("reading a jpeg picture");
	}
}

class PNGReader implements Reader{

	@Override
	public void read() {
		System.out.println("reading a png picture");
	}
	
}

//interface--ReaderFactory--getReader():
//JPEGFactory->return a JEPGReader
//PNGFactory->return a PNGReader
//GIFFactory->return a GIFReader
interface ReaderFactory{
	Reader getReader();
}

class JPEGFactory implements ReaderFactory{

	@Override
	public Reader getReader() {
		return new JPEGReader();
	}
}

class PNGFactory implements ReaderFactory{

	@Override
	public Reader getReader() {
		return new PNGReader();
	}
	
}





















