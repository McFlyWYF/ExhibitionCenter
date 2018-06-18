package HZZX.manager.informationManager.deleteInformation;

import HZZX.manager.informationManager.Information;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
删除会展信息
 */
public class DeleteInformation extends JFrame implements ActionListener {
    JButton jb1,jb2;

    JPanel jp1,jp2,jp3,jp4,jp5;

    JCheckBox jc1,jc2,jc3,jc4;//复选框

    JLabel jl1;

    //Icon icon = new ImageIcon("1.png");//为复选框添加图标

    public DeleteInformation(){

        jl1 = new JLabel("选择删除信息的方式(多选)");

        jb1 = new JButton("确定");
        jb2 = new JButton("返回");


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jc1 = new JCheckBox("会展编号");
        jc2 = new JCheckBox("展商编号");
        jc3 = new JCheckBox("展品编号");
        jc4 = new JCheckBox("类别");

        jp1.add(jl1);
        jp2.add(jc1);
        jp2.add(jc2);
        jp3.add(jc3);
        jp3.add(jc4);

        jp4.add(jb1);
        jp4.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("会展中心管理系统");
        this.setLayout(new GridLayout(5,5));
        this.setBounds(300, 200, 600, 380);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){
            dispose();
            new Information();
        }else if (e.getActionCommand() == "确定"){
            if (jc1.isSelected()){
                this.dispose();
                new MeetingId();
            }else if (jc2.isSelected()){
                this.dispose();
                new BusinessId();
            }else if (jc3.isSelected()){
                this.dispose();
                new ThingId();
            }else if (jc4.isSelected()){
                this.dispose();
                new Kind();
            }else if (jc1.isSelected() && jc2.isSelected()){
                this.dispose();
                new MBId();
            }else if (jc1.isSelected() && jc3.isSelected()){
                this.dispose();
                new MTId();
            }else if ((jc2.isSelected()) && (jc3.isSelected())){
                this.dispose();
                new BTId();
            }else if (jc1.isSelected() && jc2.isSelected() && jc3.isSelected()){
                this.dispose();
                new MBTId();
            }else if (jc1.isSelected() && jc2.isSelected() && jc3.isSelected() && jc4.isSelected()){
                this.dispose();
                new MBTK();
            }
        }
    }
}
