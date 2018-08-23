package org.nuii0.nuii0.androidforensik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import org.nuii0.nuii0.androidforensik.AuditRules.AuditRule;
import org.nuii0.nuii0.androidforensik.AuditRules.EmptyRule;
import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

public class AuditRuleAdapter extends BaseExpandableListAdapter {
    private static final String TAG = Response.class.getSimpleName();

    private Context context;
    private final IndexedLinkedMap<AuditRule, ArrayList<AusearchEntry>> auditRulesAndAusearchEntries;
    private final IndexedLinkedMap<AuditRule, ArrayList<String>> auditRulesAndHeading;

    public AuditRuleAdapter(IndexedLinkedMap<AuditRule, ArrayList<AusearchEntry>> auditRulesAndAusearchEntries, IndexedLinkedMap<AuditRule, ArrayList<String>> auditRulesAndHeading, Context context ) {
        this.context = context;
        this.auditRulesAndAusearchEntries = auditRulesAndAusearchEntries;
        this.auditRulesAndHeading = auditRulesAndHeading;
    }

    @Override
    public View getChildView(final int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        AuditRule rule = auditRulesAndAusearchEntries.getEntry(listPosition).getKey();
        final AusearchEntry entry = auditRulesAndAusearchEntries.getEntry(listPosition).getValue().get(expandedListPosition);
        final String heading = auditRulesAndHeading.getEntry(listPosition).getValue().get(expandedListPosition);

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.audit_rule_entry_element, null);
        }

        //AusearchEntry entry = auditRulesAndAusearchEntries.getEntry(listPosition).getValue().get(expandedListPosition);
        TextView entryDesc = view.findViewById(R.id.entryDesc);
        entryDesc.setText(heading);

        /*ArrayList<Syscall> list = new ArrayList<>();

        for (AusearchEntry entry: auditRulesAndAusearchEntries.getEntry(listPosition).getValue()) {
            list.addAll(entry.getSubclassType(Syscall.class));
        } */


       /* for (Syscall syscall: entry.getSubclassType(Syscall.class)) {
            Log.e(TAG, syscall.comm);
        } */

        //auditRulesAndAusearchEntries.getEntry(listPosition).getKey();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TypeAlertPrompt(context, heading, entry.toDetail() ).show();
            }
        });

        return view;
    }

    /*@Override
    public int getGroupCount() {
        return this.auditRulesAndAusearchEntries.size();
    }*/

    @Override
    public int getGroupCount() {
        return this.auditRulesAndAusearchEntries.size();
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.auditRulesAndAusearchEntries.getEntry(listPosition).getValue().size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.auditRulesAndAusearchEntries.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
       return this.auditRulesAndAusearchEntries.getEntry(listPosition).getValue().get(expandedListPosition);
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(final int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        View view = convertView;
        TextView ruleDesc;
        final AuditRule rule = auditRulesAndAusearchEntries.getEntry(listPosition).getKey();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.audit_rule_list_element, null);
        }

        ruleDesc = view.findViewById(R.id.ruleDesc);


        ruleDesc.setText(rule.toString());

        TextView alertCount = view.findViewById(R.id.alertCount);
        alertCount.setText(String.valueOf(auditRulesAndAusearchEntries.getEntry(listPosition).getValue().size()));

        ImageButton infobtn = view.findViewById(R.id.info_rule);
        infobtn.setFocusable(false);

        ImageButton callbtn = view.findViewById(R.id.delete_rule);
        callbtn.setFocusable(false);
        callbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    ((MainActivity) context).requestManager.deleteAuditRule(rule);
                    ((MainActivity) context).guiToast("Audit Regel entfernt.");
                    ((MainActivity) context).refreshAuditRuleList();
                } catch (IOException e) {
                    ((MainActivity) context).guiErrorToast(e.getMessage());
                    e.printStackTrace();
                }
            }
        });

        if (rule instanceof EmptyRule) {
            callbtn.setVisibility(View.INVISIBLE);
            infobtn.setVisibility(View.INVISIBLE);
            alertCount.setVisibility(View.INVISIBLE);
            view.findViewById(R.id.eyeIcon).setVisibility(View.INVISIBLE);
        }
        return view;


    }


    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}