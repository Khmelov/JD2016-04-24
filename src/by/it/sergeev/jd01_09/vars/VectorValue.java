package by.it.sergeev.jd01_09.vars;

import by.it.sergeev.jd01_09.interfaces.IVariable;
import by.it.sergeev.jd01_09.patterns.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VectorValue extends Variable implements IVariable{
    private double[] vector;

    public VectorValue(String str) { //конструктор из строки
        setFromString(str);
    }

    public VectorValue(double[] vector) { //конструктор из массива
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    @Override
    public Variable add(Variable var) {
        if (var instanceof VectorValue) //проверка (аргумент - вектор?)
        {
            VectorValue v1 = new VectorValue(this.vector);             //первый операнд
            VectorValue v2 = (VectorValue)var;                  //второй
            for (int i = 0; i < v1.vector.length; i++) {    //считаем
                v1.vector[i] = v1.vector[i] + v2.vector[i]; //основная операция
            }
            return v1;
        }
        if (var instanceof DoubleValue) //проверка (аргумент - скаляр?)
        {
            VectorValue v1 = new VectorValue(this.vector);
            double v2 = ((DoubleValue) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2;
            }
            return v1;
        }
        return super.add(var);
    }


    @Override
    public Variable sub(Variable var) {
        if (var instanceof VectorValue)
        {
            VectorValue v1 = new VectorValue(this.vector);
            VectorValue v2 = (VectorValue)var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2.vector[i];
            }
            return v1;
        }
        if (var instanceof DoubleValue)
        {
            VectorValue v1 = new VectorValue(this.vector);
            double v2 = ((DoubleValue) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2;
            }
            return v1;
        }
        return super.sub(var);
    }


    @Override
    public Variable mul(Variable var) {
        if (var instanceof VectorValue)
        {
            double f=0;
            VectorValue v1 = new VectorValue(this.vector);
            VectorValue v2 = (VectorValue)var;
            for (int i = 0; i < v1.vector.length; i++) {
                f = f +(v1.vector[i] * v2.vector[i]);
            }
            return new DoubleValue(f);
        }
        if (var instanceof DoubleValue)
        {
            VectorValue v1 = new VectorValue(this.vector);
            double v2 = ((DoubleValue) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2;
            }
            return v1;
        }
        return super.sub(var);
    }

    @Override
    public Variable div(Variable var) {
        if (var instanceof DoubleValue)
        {
            VectorValue v1 = new VectorValue(this.vector);
            double v2 = ((DoubleValue) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] / v2;
            }
            return v1;
        }
        return super.div(var);
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("");
        String prefix="{";
        for (Double val:vector) {
            res.append(prefix).append(val.toString());
            prefix=", ";
        }
        return res.append("}").toString();
    }

    @Override
    public void setFromString(String str) {
        String[] elem=str.split(",");
        vector=new double[elem.length];
        Matcher m= Pattern.compile(Patterns.exVal).matcher(str);
        int i=0;
        while (m.find()) {
            vector[i]=Double.parseDouble(m.group());
            i++;
        }
    }
}
