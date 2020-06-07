package HW8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int dotsToWin;

    private int cellHeight;
    private int cellWidth;

    private boolean isInit = false;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.lightGray);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    mouseReleasedUpdate(e);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if(!Logic.gameFinished){
            Logic.setHumanCoords(cellX, cellY);
        }
        System.out.printf("cellX: %d  cellY: %d \n", cellX, cellY);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            drawTitle(g);
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j]==Logic.DOT_X){
                    drawX(g, j, i);
                } else if (Logic.map[i][j]==Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
        if (Logic.checkWinLines(Logic.DOT_X)) {
            drawWin(g, "YOU WIN!!!");
        } else if (Logic.checkWinLines(Logic.DOT_O)) {
            drawWin(g, "YOU LOSE");
        } else if (Logic.isFull()) {
            drawWin(g, "!!!!DRAW!!!!");
        }
    }

    private void drawWin(Graphics g, String message) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.setComposite(AlphaComposite.SrcOver.derive(0.7f));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.red);
        g2.setComposite(AlphaComposite.SrcOver.derive(1f));
        g2.setFont(new Font("Arial", Font.BOLD, 90));
        g2.drawString(message,this.getWidth() * 0.02f, this.getHeight() / 2f + 50);
    }

    private void drawTitle(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Arial", Font.BOLD, 72));
        g2.drawString("TIC TAC TOE",this.getWidth()*0.05f, this.getHeight() / 2f);
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        float sizeFactor = 30f;
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(10));
        g2.draw(new Line2D.Float(cellX * cellWidth + sizeFactor, cellY * cellHeight + sizeFactor,
                (cellX + 1) * cellWidth - sizeFactor, (cellY + 1) * cellHeight - sizeFactor));
        g2.draw(new Line2D.Float((cellX + 1) * cellWidth - sizeFactor, cellY * cellHeight + sizeFactor,
                cellX * cellWidth + sizeFactor, (cellY + 1) * cellHeight - sizeFactor));
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        float coordFactor = 0.18f;
        float sizeFactor = 0.65f;
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(10));
        Ellipse2D.Double circle = new Ellipse2D.Double(cellX * cellWidth + cellWidth * coordFactor,
                cellY * cellHeight + cellHeight * coordFactor, cellWidth * sizeFactor, cellHeight * sizeFactor);
        g2.draw(circle);
    }


    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInit = true;
        repaint();
    }
}
