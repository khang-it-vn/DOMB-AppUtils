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


## Ánh xạ Action

## 1. 
