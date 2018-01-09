import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {

    private JButton jbtn_exit = new JButton("Exit");
    private JPanel jpn1 = new JPanel(new BorderLayout(5,5));
    private JPanel jpn_buttom = new JPanel(new GridLayout(5,1,5,5));//繪圖工具區域
    private JPanel jpn_left = new JPanel(new GridLayout(5,1,5,5));//題目區域
    private JPanel jpn_right = new JPanel(new GridLayout(1,1,5,5));//聊天室
    private JPanel jpn_top = new JPanel(new GridLayout(1,1,5,5));//時間條
    private JTextArea draw = new JTextArea();//畫圖區域
    private Container cp;

    public int x1  ,y1  ,x2  ,y2  ;

    public GameFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(100,100,600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("你畫我猜");
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));



//        離開按鈕
        jbtn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        //        小畫家

        draw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1=e.getX(); // 取得滑鼠按下時的 x 座標 (繪圖起始點的 x 座標)
                y1=e.getY(); // 取得滑鼠按下時的 y 座標 (繪圖起始點的 y 座標)
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        draw.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = draw.getGraphics();
                x2=e.getX(); // 取得拖曳滑鼠時的 x 座標
                y2=e.getY(); // 取得拖曳滑鼠時的 y 座標
                g.drawLine(x1,y1,x2,y2); // 繪出(x1,y1)到(x2,y2)的連線
                x1=x2; // 更新繪圖起始點的 x 座標
                y1=y2; // 更新繪圖起始點的 y 座標
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        cp.add(draw,BorderLayout.CENTER);

    }



    }

