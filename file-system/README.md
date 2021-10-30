# File Operations

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
