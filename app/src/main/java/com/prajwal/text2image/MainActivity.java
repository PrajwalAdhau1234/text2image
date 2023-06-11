package com.prajwal.text2image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.prajwal.text2image.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.progressBar.setVisibility(View.GONE);
        Python py = Python.getInstance();
        PyObject pyObject = py.getModule("imageFile");
        // getModule  takes  the name  of the python file
        
        binding.button.setOnClickListener(
                v->{

                    if(binding.userMsg.getText().toString().isEmpty()){
                        Toast.makeText(this, "enter  all field", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    binding.progressBar.setVisibility(View.VISIBLE);
                    PyObject pyo = pyObject.callAttr("main" ,
                            binding.userMsg.getText().toString());

                    binding.progressBar.setVisibility(View.GONE);
                    Picasso.get().load(pyo.toString()).into(binding.imageView);

                }
        );

    }
}