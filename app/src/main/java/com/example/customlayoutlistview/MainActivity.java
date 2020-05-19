package com.example.customlayoutlistview;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    ArrayList<Employee> arrEmployee =new ArrayList<Employee>();
    //Sử dụng MyArrayAdapter thay thì ArrayAdapter
    MyArrayAdapter adapter=null;
    NewMyArrayAdapter adapter1=null;
    ListView lvMonan= null;
    StringBuilder message;

    //mang luu mon
    ArrayList<Employee> arrMonChon = new ArrayList<>();


    Button btnDatMon;
    ImageButton btnRemoveAll;
    EditText editMa,editTen;
    RadioGroup genderGroup;
    CheckBox checkItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRemoveAll=(ImageButton) findViewById(R.id.btndelete);
        btnDatMon= findViewById(R.id.btndatmon);
        lvMonan=(ListView) findViewById(R.id.lvmonan);
        arrEmployee=new ArrayList<Employee>();
        arrEmployee.add(new Employee("1","Gà sốt tiêu đen",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.tieuden));
        arrEmployee.add(new Employee("2","Gà nướng sốt cam",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.sotcam));
        arrEmployee.add(new Employee("3","Gà quay",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.quay));
        arrEmployee.add(new Employee("4","Gà nướng ngũ vị",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.nguvi));
        arrEmployee.add(new Employee("5","Gà nướng muối ớt",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.muoiot));
        arrEmployee.add(new Employee("6","Lẩu gà ớt hiểm",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.laugaothiem));
        arrEmployee.add(new Employee("7","Gà lắc hongkong",false,"10.000","https://www.foody.vn/thuong-hieu/lau-ga-109?c=ho-chi-minh","lc7https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6822583,15z/data=!4m5!3m4!1s0x0:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",R.drawable.lachongkong));
        adapter=new MyArrayAdapter(
                this,
                R.layout.my_item_layout,// lấy custom layout
                arrEmployee/*thiết lập data source*/);
        lvMonan.setAdapter(adapter);//gán Adapter vào Lisview


        btnRemoveAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                xulyXoa();
            }
        });
        btnDatMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulydatmon();
                showDialog();
            }
        });
    }

    private void xulydatmon() {

       for (Employee item:arrEmployee)
       {
           if(item.isChecked()==true)
           {
               arrMonChon.add(item);
           }
        }
    }

    public void xulyXoa()
    {
        for (Employee item:arrEmployee)
        {
            if(item.isChecked()==true)
            {
                item.setChecked(false);
            }
        }

        //Sau khi xóa xong thì gọi update giao diện
        adapter.notifyDataSetChanged();
    }
    public void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
      final   EditText txtstd = dialog.findViewById(R.id.txtsodienthoai);
        Button btnxacnhan = dialog.findViewById(R.id.btnxacnhan);
        Button btnhuy = dialog.findViewById(R.id.btnhuy);
        TextView txtTongtien=dialog.findViewById(R.id.txtTongtien);
        ListView lvchonmon = dialog.findViewById(R.id.lvmonchon);

        ArrayList<Employee> arrMonDaChon = new ArrayList<>();
        int i =0;
        int tongtien=0;
        for (Employee item:arrEmployee)
        {
            if(item.isChecked()==true)
            {
                arrMonDaChon.add(item);
                tongtien+=Integer.parseInt(item.getPrice().toString().replace(".",""));
            }
        }
        //format tien te viet nam
        Locale localeVN=new Locale("vi","VN");
        NumberFormat tongtien_vn=NumberFormat.getInstance(localeVN);
        String total=tongtien_vn.format(tongtien);
        txtTongtien.setText("Tổng Tiền là :"+total);

         adapter1 = new NewMyArrayAdapter(this,R.layout.my_item,arrMonDaChon);
        lvchonmon.setAdapter(adapter1);
         message=new StringBuilder("Các món đã chọn: \n ");
        for(Employee item: arrMonDaChon){
            message.append(item.toString()+"\n");
        }
        message.append("Đợi nhà hàng 15phut");

        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isSuccess=  guiTinNhan( txtstd.getText().toString() ,  message.toString());
                if(isSuccess)
                {
                    dialog.dismiss();
                    xulyXoa();
                }
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    public boolean guiTinNhan(String sdt,String message){
         SendSms sendSms=new SendSms(this);
        return sendSms.composeSmsMessage(sdt,message);
    }
}



