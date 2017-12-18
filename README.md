#### ConstraintLayout 简单学习

    /**
     * 子控件的上、下、左、右与id、父布局的上、下、左、右对齐
     * app:layout_constraintTop_toTopOf="parent"
     * app:layout_constraintRight_toRightOf="parent"
     * app:layout_constraintBottom_toBottomOf="parent"
     * app:layout_constraintLeft_toLeftOf="@id/id"
     *
     * 子控件的上、下、左、右与id、父布局的上、下、左、右反向对齐
     * app:layout_constraintBottom_toTopOf="parent"
     * app:layout_constraintLeft_toRightOf="parent"
     * app:layout_constraintRight_toLeftOf="parent"
     * app:layout_constraintTop_toBottomOf="@id/id"
     *
     * 子控件的前后与id、父布局的前后正反向对齐
     * app:layout_constraintStart_toStartOf="parent"
     * app:layout_constraintEnd_toEndOf="parent"
     * app:layout_constraintStart_toEndOf="parent"
     * app:layout_constraintEnd_toStartOf="@id/id"
     *
     * 控件与控件的文字底部对齐（忽略控件宽高）
     * app:layout_constraintBaseline_toBaselineOf="@+id/button4"
     *
     * 该控件gone后的位置间距（一个控件相对于另一个控件在gone后的间距变化）
     * app:layout_goneMarginBottom="10dp"//相对于另一个控件gone后，该控件底部margin 10个dp
     * app:layout_goneMarginEnd="10dp"
     * app:layout_goneMarginLeft="10dp"
     * app:layout_goneMarginRight="10dp"
     * app:layout_goneMarginStart="10dp"
     * app:layout_goneMarginTop="10dp"
     *
     * 设置相对于父控件的宽和高的百分比的位置（居中和偏移(bias)）
     * app:layout_constraintVertical_bias="0.2" //设置相对父控件距离的高度的0.2倍距离为该控件的位置
     * app:layout_constraintHorizontal_bias="0.7"
     *
     * 默认宽高比（宽度确定或者高度确定）（注意宽度和高度的值）
     * app:layout_constraintDimensionRatio="16:9"
     *
     * 添加辅助线
     * android.support.constraint.Guideline
     * app:layout_constraintGuide_percent="0.5"//基准为百分比，相对于父布局的百分比
     * app:layout_constraintGuide_begin="180dp"//基准为dp，前
     * app:layout_constraintGuide_end="180dp"//基准为dp，后
     *
     * 水平方向的链式关联（前后都需要设置约束）
     * packed：居中对齐
     * spread：平均分割
     * spread_inside：两边和中间对齐
     * app:layout_constraintHorizontal_chainStyle="spread_inside"
     * app:layout_constraintVertical_chainStyle="spread_inside"// 同上
     *
     * 相当于LinerLayout的weight（同上，前后都需要设置约束）
     * app:layout_constraintHorizontal_weight="1"
     * app:layout_constraintVertical_weight="1"
     *
     * 最小宽度和高度
     * app:layout_constraintWidth_min="200dp"
     * app:layout_constraintWidth_max="200dp"
     * app:layout_constraintHeight_max="200dp"
     * app:layout_constraintHeight_min="200dp"
     *
     * 注意： MATCH_PARENT 属性无法在 ConstraintLayout 里面的 子 View 上使用。
     * 使用0dp代表占据剩余空间
     *
     * ConstraintSet 是用来通过代码管理布局属性的集合对象，可以通过这个类来创建各种布局约束，
     * 然后把创建好的布局约束应用到一个 ConstraintLayout 上
     *
     */

    BaselineLayout
    BottomNavigationItemView
    BottomNavigationMenuView
    ForegroundLinearLayout
    NavigationMenu
    BottomSheetDialog
    BottomSheetDialogFragment

    CoordinatorLayout
    AppBarLayout
    CollapsingToolbarLayout
    ToolBar
    RecycleView
    在此基础上添加下面布局
    NavigationView
    FloatingActionButton
    Snackbar

    TextInputLayout
    TextInputEditText

    TabLayout
    BottomNavigationView

    CardView


#### TextInputLayout and TextInputEditText

> TextInputLayout

    app:Theme	                         设置下划线或其他的颜色属性
    counterEnabled	                         是否显示计数器
    counterMaxLength	设置计数器的最大值,与counterEnabled同时使用
    counterTextAppearance	计数器的字体样式
    counterOverflowTextAppearance	 输入字符大于我们限定个数字符时的字体样式
    errorEnabled	                          是否显示错误信息
    errorTextAppearance	错误信息的字体样式
    hintAnimationEnabled	是否显示hint的动画,默认true
    hintEnabled	                          是否使用hint属性,默认true
    hintTextAppearance	设置hint的文字样式(指运行动画效果之后的样式)
    passwordToggleDrawable	设置密码开关Drawable图片,于passwordToggleEnabled同时使用
    passwordToggleEnabled	是否显示密码开关图片,需要EditText设置inputType
    passwordToggleTint	设置密码开关图片颜色
    passwordToggleTintMode	设置密码开关图片(混合颜色模式),与passwordToggleTint同时使用

    注意：
        添加库的时候注意要加appcompat-v7库,确保可以向后兼容
        一个TextInputLayout只能套一个EditText(或它的子类TextInputEditText)
        使用了TextInputLayout,和它的setError(),布局所占的位置会变多,设计布局注意留适当的空间
        TextInputLayout.setError()注意调用setErrorEnabled(false)清空错误信息,不然会一直显示

> TextInputEditText

    属性同EditText
    当我们的界面处于全屏时,点击一个EditText,默认情况下不是在它下面弹出键盘，
    而是进入到输入法的一个全屏的输入界面(通过配置android:imeOptions=”flagNoExtractUi”可以设为直接在当前界面显示)

    如果我们给EditText 套上了一个TextInputLayout时,TextInputLayout会拿到EditText的hint显示出来并把EditText本身的hint设为空.
    这样我们在全屏的输入界面上,就显示不出来我们设置hint,因此TextInputEditText重写了EditText

    EditText的imeOptions要与inputType同时使用,不然没有反应