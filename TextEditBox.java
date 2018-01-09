import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


@SuppressWarnings("serial")
public class TextEditBox extends JFrame{
    //添加属性
    private JComboBox comboBox_name ,comboBox_size;//字体、字号组合框
    private JButton button_larger,button_smaller,button_color;//字体变大变小和颜色选择器
    private JCheckBox checkBox_bold,checkBox_italic;//粗体、斜体复选框
    private JPopupMenu popupMenu;
    private JTextArea ta = new JTextArea();
    private JScrollPane sp = new JScrollPane(ta);
    //查找对话框属性
    private JTextField tf_search;
    private JButton button_next;
    //
    private int key = 0;

    public TextEditBox(String str){
        super(str);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dim = getToolkit().getScreenSize();//获得屏幕分辨率
        this.setBounds(dim.width / 4,dim.height / 4, 700, 480);
        JToolBar toolBar = new JToolBar();//创建工具栏
        this.add(toolBar, BorderLayout.NORTH);//工具栏添加到窗格北部
        this.add(sp);
        ta.setLineWrap(true);//换行
        ///////////////////字体
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontsName = ge.getAvailableFontFamilyNames();//获得系统字体
        comboBox_name = new JComboBox(fontsName);
        toolBar.add(comboBox_name);
        comboBox_name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize();
                ta.setFont(new Font(fontname, style, size));
            }
        });
        ///////////////////字号
        String sizestr[] = {"20","30","40","50","60","70","80","90","100"};
        comboBox_size = new JComboBox(sizestr);
        comboBox_size.setEditable(true);
        toolBar.add(comboBox_size);
        comboBox_size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                int size = Integer.parseInt((String)comboBox_size.getSelectedItem());
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                ta.setFont(new Font(fontname, style, size));
            }
        });
        ///////////////////字号加减按钮
        button_larger = new JButton("A+");
        toolBar.add(button_larger);
        button_larger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize() + 5;
                ta.setFont(new Font(fontname, style, size));
            }
        });
        button_smaller = new JButton("A-");
        toolBar.add(button_smaller);
        button_smaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize() - 5;
                ta.setFont(new Font(fontname, style, size));
            }
        });
        ////////////////
        ///////////////粗体和斜体
        checkBox_bold = new JCheckBox("粗体"); //字形复选框
        toolBar.add(checkBox_bold);
        checkBox_bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize();
                style = style ^ 1;
                ta.setFont(new Font(fontname, style, size));
            }
        });
        checkBox_italic = new JCheckBox("斜体");
        toolBar.add(checkBox_italic);
        checkBox_italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize();
                style = style ^ 2;
                ta.setFont(new Font(fontname, style, size));
            }
        });
        /////////////////
        JRadioButton radiob_color[];
        String colorstr[] = {"红","黄","蓝"};
        ButtonGroup bgroup_color = new ButtonGroup();   //按钮组
        radiob_color = new JRadioButton[colorstr.length]; //颜色单选按钮数组
        for(int i=0; i<radiob_color.length; i++ ){
            radiob_color[i] = new JRadioButton(colorstr[i]);
            bgroup_color.add(radiob_color[i]); //添加到按钮组
            toolBar.add(radiob_color[i]);   //添加到工具栏
        }
        radiob_color[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setForeground(Color.red);   //设置颜色
            }
        });
        radiob_color[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setForeground(Color.green);   //设置颜色
            }
        });
        radiob_color[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setForeground(Color.blue);   //设置颜色
            }
        });
        ///////////////颜色选择器
        button_color = new JButton("其他");
        toolBar.add(button_color);
        button_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color;
                color = JColorChooser.showDialog(TextEditBox.this, "颜色选择",Color.black);
                ta.setForeground(color);//设置颜色
            }
        });
        ///////////////////鼠标事件
        ta.addMouseListener(new MouseAdapter(){//鼠标事件处理方法，右击弹出菜单
            public void mouseClicked(MouseEvent e){
                if (e.getModifiersEx() == MouseEvent.BUTTON3_MASK) //单击的是鼠标右键
                    popupMenu.show(ta, e.getX(), e.getY()); //在鼠标单击处显示快捷菜单
            }
        });
        ////////////////////
        this.addmyMenu();   //调用自定义方法，添加菜单
        this.setVisible(true);
    }
    private void addmyMenu(){//添加主菜单、快捷菜单、对话框
        JMenuBar menuBar = new JMenuBar(); //菜单栏
        this.setJMenuBar(menuBar);  //添加菜单栏
        String menustr[] = {"文件","编辑","工具","帮助"};
        JMenu menu[] = new JMenu[menustr.length];
        for(int i = 0; i < menustr.length; i++){
            menu[i] = new JMenu(menustr[i]);  //菜单
            menuBar.add(menu[i]);    //菜单栏中加入菜单
        }
        ////////////////////////////////////
        JMenuItem menuItem_open = new JMenuItem("打开");
        menu[0].add(menuItem_open);
        menuItem_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser  fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(TextEditBox.this);
                if(result == JFileChooser.APPROVE_OPTION){
                    try{
                        File file = fileChooser.getSelectedFile();
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        ta.setText("");
                        String text;
                        while ((text = br.readLine()) != null){
                            ta.append(text);
                        }
                        fr.close();
                        br.close();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(TextEditBox.this, "打开文档出错!");
                    }
                }
            }
        });
        JMenuItem menuItem_save = new JMenuItem("保存");
        menu[0].add(menuItem_save);
        menuItem_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser  fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(TextEditBox.this);
                if(result == JFileChooser.APPROVE_OPTION){
                    try{
                        File file = fileChooser.getSelectedFile();
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String text = ta.getText();
                        fw.write(text);
                        fw.close();
                        bw.close();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(TextEditBox.this, "打开文档出错!");
                    }
                }
            }
        });
        menu[0].addSeparator(); // 加分隔线
        JMenuItem menuItem_exit = new JMenuItem("退出");
        menu[0].add(menuItem_exit);
        menuItem_exit.addActionListener(new ActionListener() {//退出
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ////////////////////////////////
        JMenu menu_style = new JMenu("字形");
        JCheckBoxMenuItem checkBoxMenuItem_bold = new JCheckBoxMenuItem("粗体");
        menu_style.add(checkBoxMenuItem_bold);
        JCheckBoxMenuItem checkBoxMenuItem_italic = new JCheckBoxMenuItem("斜体");
        menu_style.add(checkBoxMenuItem_italic);
        menu[1].add(menu_style);// 菜单加入到菜单中成为二级菜单
        checkBoxMenuItem_bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize();
                style = style ^ 1;
                ta.setFont(new Font(fontname, style, size));
            }
        });

        checkBoxMenuItem_italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontname = (String)comboBox_name.getSelectedItem();//获得字体名
                Font font = ta.getFont();   //获得文本区的当前字体对象
                int style = font.getStyle();  //获得字形
                int size = font.getSize();
                style = style ^ 2;
                ta.setFont(new Font(fontname, style, size));
            }
        });
        ////////////////////////
        JMenu menu_color = new JMenu("颜色");
        menu[1].add(menu_color);
        ButtonGroup buttonGroup = new ButtonGroup();
        String colorstr[] = {"红","黄","蓝"};
        JRadioButtonMenuItem rbmi_color[] = new JRadioButtonMenuItem[colorstr.length];
        for(int i=0; i<rbmi_color.length; i++ ){
            rbmi_color[i] = new JRadioButtonMenuItem(colorstr[i]);//单选菜单项
            buttonGroup.add(rbmi_color[i]);
            menu_color.add(rbmi_color[i]);
        }
        rbmi_color[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setForeground(Color.red);
            }
        });
        rbmi_color[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setForeground(Color.green);
            }
        });
        rbmi_color[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setForeground(Color.blue);
            }
        });
        ////////////////////////////////
        JMenuItem menuItem_countwordsum = new JMenuItem("字数统计");
        menu[2].add(menuItem_countwordsum);
        menuItem_countwordsum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                for(int i=0; i<ta.getText().length(); i++){
                    if(!ta.getText().substring(i,i+1).equals(" ")){
                        count++;
                    }
                }
                JOptionPane.showMessageDialog(TextEditBox.this,"文本框中一共有"+count+"个字符！");
            }
        });
        menu[2].addSeparator();//加分隔线
        JMenuItem menuItem_search = new JMenuItem("查找");
        menu[2].add(menuItem_search);
        menuItem_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MessageJDialog();

                button_next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str_search = tf_search.getText();
                        int len = str_search.length();
                        for (int i = key; i < ta.getText().length() - len + 1; i++){
                            String str_record = ta.getText().substring(i,i + len);
                            if(str_record.equals(str_search)){
                                key = i + 1;
                                ta.requestFocus();
                                ta.select(i,i+len);
                                return;
                            }
                        }
                    }
                });

                key = 0;
            }
        });
        JMenuItem menuItem_replace = new JMenuItem("替换");
        menu[2].add(menuItem_replace);
        menuItem_replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str_replace = JOptionPane.showInputDialog(TextEditBox.this,"请输入你要替代的字符串");
                String str_replacelater = JOptionPane.showInputDialog(TextEditBox.this,"请输入你要用来替换的内容");
                int len = str_replace.length();
                for(int i = 0; i<ta.getText().length()-len+1;i++){
                    String str_record = ta.getText().substring(i,i+len);
                    if (str_record.equals(str_replace)){
                        ta.replaceRange(str_replacelater,i,i+len);
                    }

                }
            }
        });
        ////////////////////////
        JMenuItem menuItem_about = new JMenuItem("关于");
        menu[3].add(menuItem_about);
        menuItem_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TextEditBox.this,"文本编辑器");
            }
        });
        /////////////////////////////////
        popupMenu = new JPopupMenu();
        String menuitemstr[] = {"剪切","复制","粘贴"};
        JMenuItem popmenuitem[] = new JMenuItem[menuitemstr.length];
        for(int i = 0; i < popmenuitem.length;i++){
            popmenuitem[i] = new JMenuItem(menuitemstr[i]);//菜单项
            popupMenu.add(popmenuitem[i]);//快捷菜单加入菜单项
        }
        popmenuitem[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));//设置快捷键Ctrl+X
        popmenuitem[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));//设置快捷键Ctrl+C
        popmenuitem[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));//设置快捷键Ctrl+V

        popmenuitem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.cut();//将选中文本剪切送系统剪切板
            }
        });
        popmenuitem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.copy();//将选中文本复制送系统剪切板
            }
        });
        popmenuitem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.paste();//将选中文本粘贴在当前位置
            }
        });
        ta.add(popupMenu);//文本区添加快捷菜单
    }

    //
    private class MessageJDialog extends JDialog{
        private JLabel label_tip;
        private JPanel panel_next = new JPanel();
        private JPanel panel_search = new JPanel();
        private JPanel panel_tip = new JPanel();

        public MessageJDialog(){
            super(TextEditBox.this,"查找");
            this.setSize(300,170);
            this.setLocation(TextEditBox.this.getX() + 200, TextEditBox.this.getY() + 200);
            this.setLayout(new GridLayout(3,1));
            //
            ImageIcon imageIcon = new ImageIcon("img/search.png");
            label_tip = new JLabel("请输入你要查找的字符串：",imageIcon,JLabel.LEFT);
            panel_tip.add(label_tip);
            this.add(panel_tip);
            tf_search = new JTextField(20);
            panel_search.add(tf_search);
            this.add(panel_search);
            button_next = new JButton("查找下一个");
            panel_next.add(button_next);
            this.add(panel_next);
            this.setVisible(true);
        }
    }

    public static void main(String[] args){
        new TextEditBox("文本编辑器");
    }

}