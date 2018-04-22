package com.example.user.searchablerecyclerview.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.searchablerecyclerview.R;
import com.example.user.searchablerecyclerview.models.modified.*;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 3/22/2018.
 */

public class ApplianceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> mApplianceData = new ArrayList<>();
    private LayoutClickListener mLayoutClickListener;
    private static final int SONY_TV_VIEW_TYPE = 0;
    private static final int LG_AC_VIEW_TYPE = 1;
    private static final int LG_TV_VIEW_TYPE = 2;
    private static final int LG_MOBILES_VIEW_TYPE = 3;
    private static final int SAMSUNG_AC_VIEW_TYPE = 5;
    private static final int PANASONIC_AC_VIEW_TYPE = 8;
    private static final int SAMSUNG_TV_VIEW_TYPE = 4;
    private static final int SAMSUNG_MOBILES_VIEW_TYPE = 6;
    private static final int SONY_MOBILES_VIEW_TYPE = 7;


    public void setData(List<Object> applianceData) {
        mApplianceData = applianceData;
        notifyDataSetChanged();
    }

    public void setLayoutClickListener(LayoutClickListener layoutClickListener) {
        mLayoutClickListener = layoutClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (mApplianceData.get(position) instanceof SonyTv) {
            return SONY_TV_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof LgAc) {
            return LG_AC_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof LgTv) {
            return LG_TV_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof LgMobiles) {
            return LG_MOBILES_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof SamsungTv) {
            return SAMSUNG_TV_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof SamsungAc) {
            return SAMSUNG_AC_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof SamsungMobiles) {
            return SAMSUNG_MOBILES_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof SonyMobiles) {
            return SONY_MOBILES_VIEW_TYPE;
        } else if (mApplianceData.get(position) instanceof PanasonicAC) {
            return PANASONIC_AC_VIEW_TYPE;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SONY_TV_VIEW_TYPE) {
            return new SonyTVViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == LG_AC_VIEW_TYPE) {
            return new LgACViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == LG_TV_VIEW_TYPE) {
            return new LgTVViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == LG_MOBILES_VIEW_TYPE) {
            return new LgMobilesViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == SAMSUNG_TV_VIEW_TYPE) {
            return new SamsungTVViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == SAMSUNG_AC_VIEW_TYPE) {
            return new SamsungACViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == SAMSUNG_MOBILES_VIEW_TYPE) {
            return new SamsungMobilesViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == SONY_MOBILES_VIEW_TYPE) {
            return new SonyMobilesViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        } else if (viewType == PANASONIC_AC_VIEW_TYPE) {
            return new PanasonicACViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_appliance, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SonyTVViewHolder) {
            ((SonyTVViewHolder) holder).setData((SonyTv) mApplianceData.get(position));
        } else if (holder instanceof LgACViewHolder) {
            ((LgACViewHolder) holder).setData((LgAc) mApplianceData.get(position));
        } else if (holder instanceof LgTVViewHolder) {
            ((LgTVViewHolder) holder).setData((LgTv) mApplianceData.get(position));
        } else if (holder instanceof LgMobilesViewHolder) {
            ((LgMobilesViewHolder) holder).setData((LgMobiles) mApplianceData.get(position));
        } else if (holder instanceof SamsungTVViewHolder) {
            ((SamsungTVViewHolder) holder).setData((SamsungTv) mApplianceData.get(position));
        } else if (holder instanceof SamsungACViewHolder) {
            ((SamsungACViewHolder) holder).setData((SamsungAc) mApplianceData.get(position));
        } else if (holder instanceof SamsungMobilesViewHolder) {
            ((SamsungMobilesViewHolder) holder).setData((SamsungMobiles) mApplianceData.get(position));
        } else if (holder instanceof SonyMobilesViewHolder) {
            ((SonyMobilesViewHolder) holder).setData((SonyMobiles) mApplianceData.get(position));
        } else if (holder instanceof PanasonicACViewHolder) {
            ((PanasonicACViewHolder) holder).setData((PanasonicAC) mApplianceData.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return (mApplianceData != null) ? (mApplianceData.size()) : 0;
    }

    public class SonyTVViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public SonyTVViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final SonyTv sonyTV) {
            mApplianceNameTextView.setText(sonyTV.applianceName);
            Glide.with(mProductImageView.getContext()).load(sonyTV.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(sonyTV.description);
            mSimpleRatingBar.setRating(sonyTV.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(sonyTV);

                }
            });
        }

    }

    public class LgACViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public LgACViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final LgAc lgAc) {
            mApplianceNameTextView.setText(lgAc.applianceName);
            Glide.with(mProductImageView.getContext()).load(lgAc.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(lgAc.description);
            mSimpleRatingBar.setRating(lgAc.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(lgAc);
                }
            });
        }
    }

    public class LgTVViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public LgTVViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final LgTv lgTv) {
            mApplianceNameTextView.setText(lgTv.applianceName);
            Glide.with(mProductImageView.getContext()).load(lgTv.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(lgTv.description);
            mSimpleRatingBar.setRating(lgTv.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(lgTv);
                }
            });
        }
    }

    public class LgMobilesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public LgMobilesViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final LgMobiles lgMobiles) {
            mApplianceNameTextView.setText(lgMobiles.applianceName);
            Glide.with(mProductImageView.getContext()).load(lgMobiles.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(lgMobiles.description);
            mSimpleRatingBar.setRating(lgMobiles.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(lgMobiles);
                }
            });
        }
    }

    public class SamsungACViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public SamsungACViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final SamsungAc samsungAc) {
            mApplianceNameTextView.setText(samsungAc.applianceName);
            Glide.with(mProductImageView.getContext()).load(samsungAc.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(samsungAc.description);
            mSimpleRatingBar.setRating(samsungAc.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(samsungAc);
                }
            });
        }
    }

    public class SamsungTVViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public SamsungTVViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final SamsungTv samsungTv) {
            mApplianceNameTextView.setText(samsungTv.applianceName);
            Glide.with(mProductImageView.getContext()).load(samsungTv.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(samsungTv.description);
            mSimpleRatingBar.setRating(samsungTv.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(samsungTv);
                }
            });
        }
    }

    public class SamsungMobilesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public SamsungMobilesViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final SamsungMobiles samsungMobiles) {
            mApplianceNameTextView.setText(samsungMobiles.applianceName);
            Glide.with(mProductImageView.getContext()).load(samsungMobiles.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(samsungMobiles.description);
            mSimpleRatingBar.setRating(samsungMobiles.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(samsungMobiles);
                }
            });
        }
    }

    public class SonyMobilesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public SonyMobilesViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final SonyMobiles sonyMobiles) {
            mApplianceNameTextView.setText(sonyMobiles.applianceName);
            Glide.with(mProductImageView.getContext()).load(sonyMobiles.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(sonyMobiles.description);
            mSimpleRatingBar.setRating(sonyMobiles.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(sonyMobiles);
                }
            });
        }
    }

    public class PanasonicACViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.applianceNameTextView)
        TextView mApplianceNameTextView;
        @BindView(R.id.descriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.productImageView)
        ImageView mProductImageView;
        @BindView(R.id.ratingBar)
        SimpleRatingBar mSimpleRatingBar;
        private View mLayout;

        public PanasonicACViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setData(final PanasonicAC panasonicAC) {
            mApplianceNameTextView.setText(panasonicAC.applianceName);
            Glide.with(mProductImageView.getContext()).load(panasonicAC.imageUrl).into(mProductImageView);
            mDescriptionTextView.setText(panasonicAC.description);
            mSimpleRatingBar.setRating(panasonicAC.rating);
            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLayoutClickListener != null)
                        mLayoutClickListener.onClick(panasonicAC);
                }
            });
        }
    }

    public interface LayoutClickListener {
        void onClick(Object applianceData);
    }

}
