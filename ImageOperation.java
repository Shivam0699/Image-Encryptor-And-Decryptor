
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation
{
    public static void operate(int key)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        //getting the selected file

        try
        {
            FileInputStream fis = new FileInputStream(file);
            byte []data = new byte[fis.available()];
            fis.read(data);

            int  i=0;

            for(byte b:data)
            {
                //System.out.println(b);
                data[i] = (byte) (b^key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {

        JFrame f = new JFrame();
        f.setTitle("Image Encryption And Decryption");
        f.setSize(800,800);
        f.setBackground(Color.BLUE);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Italics",Font.BOLD,20);
        //creating button 

        JButton button = new JButton();
        button.setText("Encryption");
        button.setFont(font);

        JButton button2 = new JButton();
        button2.setText("Decryption");
        button2.setFont(font);

        //creating text field

        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Romans",Font.BOLD,16));

        JTextField textField2 = new JTextField(10);
        textField2.setFont(new Font("Romans",Font.BOLD,16));

        JTextField prom = new JTextField("Enter a PassKey");
        prom.setFont(new Font("Romans",Font.BOLD,14));
        prom.setEditable(false);

        JTextField prom2 = new JTextField("Enter a PassKey");
        prom2.setFont(new Font("Romans",Font.BOLD,14));
        prom2.setEditable(false);

        // adding action listener to button

        button.addActionListener(e->{                 //this is a lamda function
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        button2.addActionListener(e->{                 //this is a lamda function
            System.out.println("button clicked");
            String text = textField2.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        //setting layout of the frame

        GridLayout lay = new GridLayout(2,2);
        lay.setHgap(5);
        f.setLayout(lay);

        f.add(button);
        f.add(prom);
        f.add(textField);
        //f.add(Box.createRigidArea(new Dimension(0, 5)));
        f.add(button2);
        f.add(prom2);
        f.add(textField2);
        

        f.setVisible(true);
    }
}