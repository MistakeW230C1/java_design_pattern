package com.mistake.day6.demo7;

import com.mistake.day4.demo1.DbProc;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GraphShow extends AbstractShow {


    @Override
    public String show(String no) throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String s = "";
        String title[] = para.getTitle();
        String strSql = para.getPerSql() + "'" + no + "'";
        DbProc dbProc = new DbProc();
        Connection connection = dbProc.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(strSql);
        String name ="";
        if (resultSet.next()){
            name = resultSet.getString(2);
            for (int i = 3; i <title.length; i++) {
                dataset.addValue(resultSet.getInt(i) ,name,title[i-1]);
            }
        }
        JFreeChart chart = ChartFactory.createLineChart(name,"","",dataset, PlotOrientation.VERTICAL,false,false,false);
        ChartUtils.saveChartAsJPEG(new File("d:/tmp.jpg"),100,chart,500,300);
        statement.close();
        resultSet.close();
        // 形成img标签
        s = "<img src ='d:/tmp.jpg' border ='0'></img>";
        return s;
    }


}
