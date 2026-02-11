import java.awt.*;

public class Display {

    // public static void main(String[] args) {
    //     String[] valueNames = new String[] {"value1123ajsdhbf", "value2kahgdvf", "value3", "value4", "value5asdfghvaskhfgvasdkfhbv asdfknb v", "value6", "value7", "value8", "value9", "valuea", "valueb"};
    //     double[][] corrCoeffs = new double[valueNames.length][valueNames.length];
    //     for(int i = 0; i < corrCoeffs.length; i ++) {
    //         for(int j = 0; j < corrCoeffs.length; j ++) {
    //             corrCoeffs[i][j] = Math.random();
    //             if(Math.random() < 0.5) {
    //                 corrCoeffs[i][j] *= -1;
    //             }
    //         }
    //     }
    //     draw(corrCoeffs, valueNames);
    // }

    public static void draw(double[][] corrCoeffs, String[] valueNames) {
        //Check invalid parameters
        int width = 1800;
        int height = 600;
        int numValues = valueNames.length;

        if(width % (numValues + 1) != 0) {
            System.out.println("\nInvalid width!\nMake sure your width is divisible by the number of cells wide.\nCurrent width: " + width + "\nTry some of the following values instead: ");
            for(int i = 50; i < 200; i += 10) {
                System.out.print((numValues + 1) * i + "   ");
            }
            return;
        }
        if(height % (numValues + 1) != 0) {
            System.out.println("\nInvalid height!\nMake sure your height is divisible by the number of cells wide.\nCurrent height: " + height + "\nTry some of the following values instead: ");
            for(int i = 50; i < 200; i += 10) {
                System.out.print((numValues + 1) * i + "   ");
            }
            return;
        }

        if(corrCoeffs == null) {
            System.out.println("\nCorrelation coefficient array is null.");
            return;
        }

        if(corrCoeffs.length != corrCoeffs[1].length || corrCoeffs.length != valueNames.length) {
            System.out.println("\nDifferent amount of values and correlation coefficients.");
            return;
        }

        //Setup graphics
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font font = new Font("Arial", Font.BOLD, 15);
        g.setFont(font);

        int cellWidth = width / (numValues + 1);
        int cellHeight = height / (numValues + 1);
        panel.setBackground(new Color(0, 0, 0));


        //Fix value name lengths
        int maxLength = cellWidth / 8;
        for(int i = 0; i < numValues; i ++) {
            if(valueNames[i].length() > maxLength) {
                valueNames[i] = valueNames[i].substring(0, maxLength - 2) + "...";
            }
        }

        //Draw labels
        g.setColor(new Color(255, 255, 255));
        for(int i = cellWidth; i < width; i += cellWidth) {
            g.drawString(valueNames[(i - cellWidth) / cellWidth], i, cellHeight / 2);
        }
        for(int i = cellHeight + cellHeight / 2; i < height; i += cellHeight) {
            g.drawString(valueNames[(i - cellHeight) / cellHeight], 0, i);
        }

        //Fill boxes
        for(int i = 0; i < corrCoeffs.length; i ++) {
            for(int j = 0; j < corrCoeffs[i].length; j ++) {
                if(i == j) {
                    g.setColor(new Color(150, 150, 150));
                    g.fillRect((i * cellWidth) + cellWidth, (j * cellHeight) + cellHeight, cellWidth, cellHeight);
                    continue;
                }
                double num = corrCoeffs[i][j];
                if(num < 0) {
                    g.setColor(new Color((int)(255 * Math.abs(num)), 0, 0));
                } else {
                    g.setColor(new Color(0, (int)(255 * Math.abs(num)), 0));
                }
                g.fillRect((i * cellWidth) + cellWidth, (j * cellHeight) + cellHeight, cellWidth, cellHeight);
            }
        }

        //Draw grid
        for(int i = 0; i < width; i += cellWidth) {
            for(int j = 0; j < height; j += cellHeight) {
                g.setColor(new Color(255, 255, 255));
                g.drawRect(i, j, cellWidth, cellHeight);
            }
        }
    }
}
