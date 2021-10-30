# File Operations

### Resources
- [Java File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html)
- 

### Imports
```java
import java.io.File;
```

### File and Directory

```java
File f = new File("dummy.txt");

f.createNewFile();
f.exists()
Utils.writeContents(f, "Hello World");

File d = new File("dummy");
d.mkdir();
```

### Serialization
```java
import java.io.Serializable;
class B implements Serializable {
  // logic
}
```

### Streams
```java
import java.io.ObjectOutputStream;

try {
    ObjectOutputStream out =
        new ObjectOutputStream(new FileOutputStream(outFile));
    out.writeObject(b); // b is a Serializable object
    out.close();
} catch (IOException excp) {
    ...
}

/* Separate File */


File inFile = new File(saveFileName);
try {
    ObjectInputStream inp =
        new ObjectInputStream(new FileInputStream(inFile));
    b = (Board) inp.readObject(); 
    inp.close();
} catch (IOException | ClassNotFoundException excp) {
    ...
    b = null;
}
```

### TO READ List
- BufferedReader
```java
BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
```
- Command Object
```java
Command currentCommand=new Command(line);
File currentFile= new File(currentCommand.getLsPath());
```


