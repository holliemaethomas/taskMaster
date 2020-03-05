//package com.thhollie.taskMaster;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.amazonaws.amplify.generated.graphql.ListTasksQuery;
//
//import java.util.List;
//
//    /**
//     * {@link RecyclerView.Adapter} that can display a Task and makes a call to the
//     * specified {@link}.
//     */
//    public class MyTaskRecyclerViewAdapter extends RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder> {
//
//        private static final String TAG = "rnr";
//        private List<ListTasksQuery.Item> mValues;
//        private final OnTaskClickedListener mListener;
//
//        public static interface OnTaskClickedListener {
//            void taskClicked(ListTasksQuery.Item i);
//        }
//
//        public MyTaskRecyclerViewAdapter(List<ListTasksQuery.Item> items, OnTaskClickedListener listener) {
//            mValues = items;
//            mListener = listener;
//        }
//
//        public void setTaskList (List<ListTasksQuery.Item> taskList) {
//            this.mValues = taskList;
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.fragment_task, parent, false);
//
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(final ViewHolder holder, int position) {
//            holder.mItem = mValues.get(position);
//            holder.mIdView.setText(mValues.get(position).title());
//            holder.mContentView.setText(mValues.get(position).details());
//
//            holder.mView.setOnClickListener((v) -> {
//                mListener.taskClicked(holder.mItem);
//            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return mValues.size();
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            public final View mView;
//            public final TextView mIdView;
//            public final TextView mContentView;
//            public ListTasksQuery.Item mItem;
//
//            public ViewHolder(View view) {
//                super(view);
//                mView = view;
//                mIdView = (TextView) view.findViewById(R.id.title);
//                mContentView = (TextView) view.findViewById(R.id.details);
//            }
//
//            @Override
//            public String toString() {
//                return super.toString() + " '" + mContentView.getText() + "'";
//            }
//        }
//    }

