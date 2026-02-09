import java.awt.*;

public class Display {
    public static void main(String[] args) {
        String[] valueNames = new String[] {"value1123ajsdhbf", "value2", "value3", "value4", "value5", "value6", "value7", "value8", "value9", "valuea", "valueb"};
        double[][] corrCoeffs = new double[valueNames.length][valueNames.length];
        for(int i = 0; i < corrCoeffs.length; i ++) {
            for(int j = 0; j < corrCoeffs.length; j ++) {
                corrCoeffs[i][j] = Math.random();
                if(Math.random() < 0.5) {
                    corrCoeffs[i][j] *= -1;
                }
            }
        }
        draw(corrCoeffs, valueNames);
    }
    public static void draw(double[][] corrCoeffs, String[] valueNames) {
        //Setup graphics
        int width = 1800;
        int height = 900;
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font font = new Font("Arial", Font.BOLD, 15);
        g.setFont(font);
        int numValues = valueNames.length;
        int cellWidth = width / (numValues + 1);
        int cellHeight = height / (numValues + 1);
        panel.setBackground(new Color(0, 0, 0));

        //Fix value name lengths
        for(int i = 0; i < numValues; i ++) {
            if(valueNames[i].length() > 13) {
                valueNames[i] = valueNames[i].substring(0, 11) + "...";
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
                    g.setColor(new Color(255, 255, 0));
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
