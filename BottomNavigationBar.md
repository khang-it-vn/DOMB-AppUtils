# Cách thiết kế Bottom Navigation Bar
> Sử dụng thiết kế từ MaterialDesign https://m2.material.io/

## Thực Hiện Thiết Kế 
![image](https://user-images.githubusercontent.com/84958646/210090684-97db25ee-6b5d-4cfa-b543-182d7905769f.png)

## 1. implementation
> implementation 'com.google.android.material:material:1.7.0'

## 2. Tạo resource file
##### Bước 1:
> res > New > Directory > name: 'menu'   || Hoàn tất

##### Bước 2:
>  menu > New > Menu Resource File > name: 'tùy ý, <menu_bottom_navigation>' || Hoàn tất

Nội dung trong file menu_bottom_navigation như sau:

    <item android:id="@+id/home"
        android:title="@string/action_home"
        android:icon="@drawable/home"/>
    <item android:id="@+id/history"
        android:title="@string/action_history"
        android:icon="@drawable/history"/>
    <item android:icon="@drawable/profile"
        android:title="@string/action_profile"
        android:id="@+id/profile"/>

Trong đó, với mỗi item sẽ có 3 giá trị tướng ứng sau: @icon: <hình ảnh trong drawable>, @title: <Giá trị phía dưới icon có thể truyền trực tiếp, ở đây giá trị được đăt trong thư mục values, file string.xml >, @id 
Nếu không truyền title thì chỉ hiển thị @icon, nếu trường hợp bạn không muốn có giá trị dưới @icon

## 3. Hiển thị trên Activity
Để hiển thị trên activity, vào activity muốn hiển thị và thêm đoạn code sau:

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNavigationBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:menu="@menu/menu_bottom_navigation_bar"
        app:itemBackground="#F18E87"
        app:itemIconTint="#FFFCF5"
        app:itemTextColor="@color/white"
        />
Trong đó: com.google.android.material.bottomnavigation.BottomNavigationView sẽ có sau khi thực hiện implementation ở bước 1


## Flow Fragment

## 1. Add Fragment vào file UI
        <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewPaperMain"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toTopOf="@+id/bottomNavigationBar"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
## 2. Ánh xạ 
Khai báo 2 biến ánh xạ fragment và bottom navigation
> private BottomNavigationView bottomNavigationView; private ViewPager viewPaperMain;

Ánh xạ:
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        viewPaperMain = findViewById(R.id.viewPaperMain);

## 3. Set sự kiện, khi nhấn vào một item hiển thị viewpaper của item đó
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(NavigationMain.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        viewPaperMain.setCurrentItem(0);
                        break;
                    case R.id.history:
                        Toast.makeText(NavigationMain.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        viewPaperMain.setCurrentItem(1);
                        break;
                    case R.id.profile:
                        Toast.makeText(NavigationMain.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        viewPaperMain.setCurrentItem(2);
                        break;


                }
                item.setChecked(true);
                return false;
            }
        });
         setUpViewPaper();
         
Hàm setUpViewPaper như sau:

        private void setUpViewPaper()
        {
            ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.viewPaperMain.setAdapter(viewPaperAdapter);
        }
Mỗi một item tương ứng với một Fragment, ta có 3 Fragment sau kế thừa từ Fragment: 
> HomeFragment, HistoryFragment, ProfileFragment
Nội dung mỗi Fragment như sau:

        public class HomeFragment  extends Fragment {

            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                View view = inflater.inflate(R.layout.fragment_home,container,false);
                return view;
            }
         }
Tương tự với các fragment còn lại, ta cần thay đổi layout tương ứng.
Với mỗi Fragment sẽ có một layout riêng, ta có 3 layout:
>fragment_home, fragment_history, fragment_profle

Ví dụ: fragment_home

        <?xml version="1.0" encoding="utf-8"?>
        <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:background="@color/purple_200"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="304dp"
            android:text="TextView"

            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.498"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
        </androidx.constraintlayout.widget.ConstraintLayout>
Chúng ta có thể custom tùy ý, đây là nội dung sẽ thực thi khi hiển thi các fragment này
  
