import java.io.File;
class Filedir {
    public static void main(String[] args) {
    	System.out.println(System.getProperty("user.dir"));
    	File f = new File("dummy.txt");
		if (f.exists()){
			System.out.println("this file exists");
		} else {
			System.out.println("currently this file does not exist");
		}

		try {
			boolean created = f.createNewFile();
			if (created){
				System.out.println("SUCCESS - File created!");
			} else {
				System.out.println("ERROR - File already exists!");
			}
		} catch (Exception e){
			// IO Exception
			System.err.println(e);
		}
        

		if (f.exists()){
			System.out.println("this file exists");
		} else {
			System.out.println("currently this file does not exist");
		}

        File d = new File("dummy");
    	d.mkdir();
    }
}
