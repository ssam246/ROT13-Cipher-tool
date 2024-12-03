# **ROT Cipher Tool**

The **ROT Cipher Tool** is a Java-based desktop application that allows users to encrypt or decrypt text using the ROT cipher with a customizable offset. It features a clean and interactive GUI, enabling real-time text processing and clipboard integration.
![image](https://github.com/user-attachments/assets/8e61ee21-8c4d-4248-9c47-3ffecf4eff35)

---

## **Features**

- **Real-Time Encryption/Decryption**: Automatically processes the input text as you type.
- **Customizable Offset**: Choose any ROT cipher offset from 1 to 25.
- **Clipboard Integration**: Copy the output text directly to your clipboard with a single click.
- **Clear Input/Output**: Quickly reset the input and output fields.
- **User-Friendly Interface**: Built using Java Swing with a responsive layout and intuitive controls.

---

## **Prerequisites**

1. **Java Development Kit (JDK)**:
   - Ensure JDK 8 or higher is installed.
   - Verify installation:
     ```bash
     java -version
     ```
2. **IDE or Terminal**:
   - Use any Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans) or the terminal for execution.

---

## **Setup and Execution**

### **1. Clone or Download the Repository**
```bash
git clone https://github.com/ssam246/ROT13-Cipher-tool
cd rot-cipher-tool
```

### **2. Compile the Code**
Navigate to the project directory and compile the source code:
```bash
javac Main.java
```

### **3. Run the Application**
After compilation, run the application:
```bash
java Main
```

---

## **How to Use**

1. **Launch the Application**:
   - Upon running, the application window will open with input/output fields and controls.

2. **Enter Text**:
   - Type your text into the **Input** field. The processed output will appear in the **Output** field in real time.

3. **Adjust the Offset**:
   - Use the **Cipher Offset** spinner to change the ROT cipher offset (default is 13).

4. **Copy Output**:
   - Click the **Copy Output** button to copy the encrypted/decrypted text to your clipboard.

5. **Clear Fields**:
   - Use the **Clear** button to reset both input and output fields.

---

## **Example Workflow**

1. **Input Text**:
   Enter the following text in the input field:
   ```
   HelloWorld
   ```

2. **Adjust Offset**:
   Set the cipher offset to `13`.

3. **Output**:
   The output field will display:
   ```
   UryybJbeyq
   ```

4. **Copy to Clipboard**:
   Click **Copy Output** to copy `UryybJbeyq` to your clipboard.

---

## **Error Handling**

- **Empty Output**:
  - If you attempt to copy without any text in the output field, the application displays a warning message:  
    *"Output is empty!"*

- **Invalid Offset**:
  - The spinner only allows offsets between 1 and 25 to ensure valid ROT cipher operations.

---

## **File Structure**

```plaintext
├── Main.java        # Main application source code
├── README.md        # Documentation
```

---

## **Contributing**

Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch for your changes:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

---

## **License**

This project is licensed under the **MIT License**.  

---

## **Disclaimer**

This tool is designed for educational purposes and lightweight encryption only. It should not be used for securing sensitive information, as the ROT cipher is not cryptographically secure.

---

### **Made with 💻 and 🔐 by Stephen Sam**

