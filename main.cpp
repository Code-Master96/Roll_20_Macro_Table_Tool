#include <iostream>
#include <string>
using namespace std;

int main(int argc, const char * argv[]) {
    void wait();
    void clear();
    
    bool done = false;
    int i = 0, repeat = 0;
    string outStr = "";
    char doneStr[1001] = "";
    char attribute[1001] = "";
    float x[1000], y[1000], r[1000];
    
    clear();
    cout << "CodeMaster96's Macro Tool v1\n\n\n\n";
    cout << "The attribute lookes like this:\n @{***somthing***|***somthing}\n\n";
    cout << endl;
    cout << "Enter the attribute:";
    cin.getline(attribute, 1000);
    for(;i<1000 && !done;i++)
    {
        if(repeat > 10)
        {
            clear();
            cout << "Sorry an error is forcing me to close down... Good Bye." << endl;
            cout << endl;
            return 1;
        }
        clear();
        for(int j = 0; j<i; j++)
        {
            cout << "[" << x[j] << ", " << y[j] << ") --> " << r[j] << endl;
        }
        cout << endl;
        cout  << "[x,y) --> r" << endl << "Enter x: ";
        cin >> x[i];
        cin.ignore();
        cout << endl;
        cout << "Enter y: ";
        cin >> y[i];
        cin.ignore();
        cout << endl;
        if(!(x[i]<y[i]))
        {
            cout << "[" << x[i] << ", " << y[i] << ") is not a valid." << endl;
            cout << "Are you done?(y/n): ";
            cin.getline(doneStr, 1000);
            if(doneStr[0] == 'y')
            {
                done = true;
            }
            cout << endl;
            i--;
            repeat++;
            
        }
        else
        {
            bool fail = false;
            for(int j =0; j < i && !fail; j++)
            {
                fail = true;
                
                if(x[i] < x[j] && y[i] <= x[j])
                    fail = false;
                
                if(x[i] >= y[j] && y[i] > y[j])
                    fail = false;
            }
            if(fail)
            {
                cout << "[" << x[i] << ", " << y[i] << ") conflicts with other ranges." << endl;
                cout << "Are you donea?(y/n): ";
                cin.getline(doneStr, 1000);
                if(doneStr[0] == 'y')
                {
                    done = true;
                }
                cout << endl;
                i--;
                repeat++;
            }
            else
            {
                cout << "Enter r: ";
                cin >> r[i];
                cin.ignore();
                repeat = 0;
            
                if(i+1 < 1000)
                {
                    cout << "Are you doneb?(y/n): ";
                    cin.getline(doneStr, 1000);
                    if(doneStr[0] == 'y')
                    {
                        done = true;
                    }
                    cout << endl;
                }
                else
                {
                    cout << "you have entered the maximum allowed values." << endl;
                    done = true;
                }
            }
        }
    }
    outStr = "[[round(100*(";
    string a = attribute;
    for (int j = 0; j < i; j++)
    {
        string rStr = to_string(r[j]), f = to_string(x[j]), s = to_string(y[j]);
        if (j!=0)
        {
            outStr += "+";
        }
        outStr += rStr + "*((abs(" + a + " - " + f + " + 0.001)+ "+a+"-"+f+"+0.001)/0.002 - (abs("+a+"-"+f+")+"+a+"-"+f+")/0.002- (abs("+a+" - "+s+"+ 0.001)+"+a+"-"+s+"+0.001)/0.002 + (abs("+a+"-"+s+")+"+a+"-"+s+")/0.002)";
    }
    outStr += "))/100]]";
    
    clear();
    cout << outStr;
    cin.get();
    return 0;
    
}

void wait()
{
    cout << "press enter to continue...";
    cin.get();
}

void clear()
{
    for(int i = 0; i < 30; i++)
    {
        cout << endl;
    }
}
