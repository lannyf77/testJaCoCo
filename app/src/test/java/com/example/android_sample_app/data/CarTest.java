package com.example.android_sample_app.data;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CarTest {

    private Car mCar = new Car("Model 3", "Tesla");

    @Test
    public void getManufacturer() {
        assertThat(mCar.getManufacturer(), is(equalTo("Tesla")));
    }

    @Test
    public void getName() {
        assertThat(mCar.getName(), is(equalTo("Model 3")));
    }

    @Test
    public void equal_valid_equal() {
        assertThat(mCar, is(equalTo(mCar)));
    }

    @Test
    public void equal_valid() {
        Car carTesla2 = new Car("Model 3", "Tesla");
        int hash1 = mCar.hashCode();
        int hash2 = carTesla2.hashCode();

        boolean b = mCar.equals(hash1);

        System.out.println("+++ equal:"+b+", hash1:"+hash1+", hash2:"+hash2);

        assertThat(mCar, is(equalTo(carTesla2)));
    }

    @Test
    public void equal_invalid() {
        Car carTesla = new Car("Model 3", "Tesla");
        Car carPorsche = new Car("Cayenne coupe", "Porsche");
        assertThat(carTesla, not(is(equalTo(carPorsche))));
    }
}
