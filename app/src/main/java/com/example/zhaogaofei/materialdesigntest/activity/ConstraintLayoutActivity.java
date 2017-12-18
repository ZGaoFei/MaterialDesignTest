package com.example.zhaogaofei.materialdesigntest.activity;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.materialdesigntest.R;

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
public class ConstraintLayoutActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ConstraintLayoutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        ConstraintSet set = new ConstraintSet();
    }
}
