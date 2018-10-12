package megvii.testfacepass.adapter;

/**
 * Created by Administrator on 2018/7/3.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.io.File;
import java.util.List;

import megvii.facepass.FacePassException;
import megvii.facepass.FacePassHandler;
import megvii.testfacepass.MyApplication;
import megvii.testfacepass.R;
import megvii.testfacepass.beans.Subject;
import megvii.testfacepass.ui.MainActivity201;
import megvii.testfacepass.utils.DateUtils;
import megvii.testfacepass.utils.GlideUtils;
import megvii.testfacepass.view.GlideCircleTransform;

/**
 * Created  2018/1/15.
 */


public class DiBuAdapter extends RecyclerView.Adapter<DiBuAdapter.ViewHolder>{

    private List<Subject> list;
    private Context context;
    private int dw,dh;
    private FacePassHandler facePassHandler;



    public DiBuAdapter(List<Subject> list, Context context,int dw,int dh,FacePassHandler handler)
    {
        this.list = list;
        this.context=context;
        this.dw=dw;
        this.dh=dh;
        facePassHandler=handler;

      }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dibuitem, parent, false);
             ScreenAdapterTools.getInstance().loadView(view);


           return new ViewHolder(view);
      }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

              //  if (!list.get(position).getName().equals("")){
                    holder.name.setText(list.get(position).getName()+"");
//                }else {
//                    holder.name.setText(  Html.fromHtml("<font color='#0d2cf9'><big>嘉宾您好</big></font>"));
//                }

            if (list.get(position).getShijian()!=null){
                String ss[]=list.get(position).getShijian().split("-");
                holder.riqi.setText(ss[0]);
                holder.xiaoshi.setText(ss[1]);
            }


        try {

            if (list.get(position).getDisplayPhoto()!=null){
                Glide.with(context)
                        .load(new File(list.get(position).getDisplayPhoto()))
                        .apply(GlideUtils.getRequestOptions())
                        .into(holder.touxiang);
            }else {
                Bitmap bitmap = facePassHandler.getFaceImage(list.get(position).getTeZhengMa().getBytes());
                Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
                Glide.with(context)
                        .load(drawable)
                        .apply(GlideUtils.getRequestOptions())
                        .into(holder.touxiang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams)holder.touxiang.getLayoutParams();
//        params1.height=dh/13;
//        params1.width=dh/16;
//        params1.leftMargin=40;
//        holder.touxiang.setLayoutParams(params1);
//        holder.touxiang.invalidate();
//
        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) holder.root_rl.getLayoutParams();
        params2.width=dw/4;
        params2.height=dh/2;
        holder. root_rl.setLayoutParams(params2);
        holder. root_rl.invalidate();


            }

    @Override
    public int getItemCount() {

             return list.size();

            }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView riqi,name,xiaoshi;
        ImageView touxiang;
        RelativeLayout root_rl;

        ViewHolder(View itemView) {
            super(itemView);
             touxiang =itemView.findViewById(R.id.touxiang);
             root_rl = itemView .findViewById(R.id.root_rl2);
             name = itemView.findViewById(R.id.name);
             riqi = itemView .findViewById(R.id.riqi);
             xiaoshi = itemView.findViewById(R.id.xiaoshi);
        }
    }

}