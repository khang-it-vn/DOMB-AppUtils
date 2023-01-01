# Thiết kế flow home item fragment
## 1. Mỗi item tương ứng với một Fragment
![image](https://user-images.githubusercontent.com/84958646/210164437-37b49df5-0e29-47c2-9b5d-c8bd87987d81.png)

Ta có các fragment sau:
  SuaDienFragment   ==> Layout: fragment_sua_dien \n 
  SuaNuocFragment   ==> Layout: fragment_sua_nuoc \n
  SuaXeFragment     ==> Layout: fragment_sua_xe \n
  TramXangFragment  ==> Layout: fragment_tram_xang \n
  SuaOtoFragment    ==> Layout: fragment_sua_oto \n
  CuuHoOtoFragment  ==> Layout: fragment_cuu_ho_oto \n
  CuuHoXeMayFragment ==> Layout: fragment_cuu_ho_xemay  \n


## 2. Set sự kiện cho mỗi item khi được click hiển thị fragment tương ứng

##### 2.1 Ánh xạ các item tại fragment_home vào file HomeFragment
    // ánh xạ
        ImageView imgSuaDien = view.findViewById(R.id.imgViewSuaDien);
        ImageView imgSuaNuoc = view.findViewById(R.id.imgViewSuaNuoc);
        ImageView imgSuaXe = view.findViewById(R.id.imgViewSuaXe);
        ImageView imgTramXang = view.findViewById(R.id.imgViewTramXang);
        ImageView imgSuaOto = view.findViewById(R.id.imgViewSuaOto);
        ImageView imgCuuHoOto = view.findViewById(R.id.imgViewCapCuuOto);
        ImageView imgCuuHoXeMay = view.findViewById(R.id.imgViewCapCuuXeMay);
##### 2.2 Set sự kiện, khi click item sẽ thay thế Fragment tương ứng
     // set sự kiện
        setImageViewOnClickListener(imgSuaDien, R.id.fragment_home,new SuaDienFragment());
        setImageViewOnClickListener(imgSuaNuoc, R.id.fragment_home,new SuaNuocFragment());
        setImageViewOnClickListener(imgSuaXe, R.id.fragment_home,new SuaXeFragment());
        setImageViewOnClickListener(imgTramXang, R.id.fragment_home,new TramXangFragment());
        setImageViewOnClickListener(imgSuaOto, R.id.fragment_home,new SuaOtoFragment());
        setImageViewOnClickListener(imgCuuHoOto, R.id.fragment_home,new CuuHoOtoFragment());
        setImageViewOnClickListener(imgCuuHoXeMay, R.id.fragment_home,new CuuHoXeMayFragment());
##### 2.3 Hàm set sự kiện như sau:

    private void setImageViewOnClickListener(ImageView imgClicked, int fragment, Fragment InstanceFragment) {
        imgClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(fragment, InstanceFragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.commit();
            }
        });
    }
